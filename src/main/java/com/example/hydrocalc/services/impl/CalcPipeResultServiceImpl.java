package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.calculator.CalculatorConstants;
import com.example.hydrocalc.calculator.HydroCalculator;
import com.example.hydrocalc.model.binding.PePipeBindingModel;
import com.example.hydrocalc.model.binding.PvcOPipeBindingModel;
import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.model.enums.PvcOPipeEnum;
import com.example.hydrocalc.model.enums.WaterTemperatureEnum;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.repositrory.CalculatorPipeResultRepository;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Service
public class CalcPipeResultServiceImpl implements CalcPipeResultService {
    private final CalculatorPipeResultRepository calculatorPipeResultRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public CalcPipeResultServiceImpl(CalculatorPipeResultRepository calculatorPipeResultRepository, UserService userService, ModelMapper modelMapper) {
        this.calculatorPipeResultRepository = calculatorPipeResultRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewResult(CalculatorPipeResults result) {
        CalculatorPipeResults save = this.calculatorPipeResultRepository.save(result);
    }

    @Override
    @Transactional
    public Long calculateByInternalDiameter(PipeDIBindingModel inputByInternalDiameter, String username) {
        double di = inputByInternalDiameter.getDI();
        double flowInLitersPerSeconds = inputByInternalDiameter.getFlowInLitersPerSeconds();
        double length = inputByInternalDiameter.getLength();
        double roughnessHeightInMm = inputByInternalDiameter.getRoughnessHeightInMm();
        WaterTemperatureEnum waterTemperature = inputByInternalDiameter.getWaterTemperature();
        double kinematicViscosity = getKinematicViscosity(waterTemperature);
        CalculatorPipeResults calculatorPipeResults = HydroCalculator.calculatePipe(di, flowInLitersPerSeconds, roughnessHeightInMm, length, kinematicViscosity);
        setWaterTemperature(waterTemperature, calculatorPipeResults);

        UserEntity userByUsername = this.userService.findUserByUsername(username);
        calculatorPipeResults.setCreatedOn(getPostedOnNow());
        calculatorPipeResults.setMaterial("N/A");
        calculatorPipeResults.setUser(userByUsername);
        return this.calculatorPipeResultRepository.save(calculatorPipeResults).getId();
    }

    @Override
    public CalculatorPipeResultsModelView findResultById(Long savedResultId) {
        CalculatorPipeResults savedResult = this.calculatorPipeResultRepository.findById(savedResultId).orElse(null);
        if (savedResult != null) {
            return this.modelMapper.map(savedResult, CalculatorPipeResultsModelView.class);
        }
        return null;
    }

    @Override
    public Long calculatePePipe(PePipeBindingModel pePipeBindingModel, String username) {
        double internalDiameter = getPePipeInternalDiameter(pePipeBindingModel);
        NominalPressure nominalPressure = pePipeBindingModel.getNominalPressure();
        if (internalDiameter == 0) {
            return -1L;
        }

        WaterTemperatureEnum waterTemperature = pePipeBindingModel.getWaterTemperature();


        double kinematicViscosity = getKinematicViscosity(waterTemperature);

        CalculatorPipeResults pePipeResult = HydroCalculator.calculatePipe(internalDiameter, pePipeBindingModel.getFlowInLitersPerSeconds(),
                pePipeBindingModel.getRoughnessHeightInMm(), pePipeBindingModel.getLength(), kinematicViscosity);
        setWaterTemperature(waterTemperature, pePipeResult);
        setDnAndPn(pePipeBindingModel, pePipeResult);
        pePipeResult.setCreatedOn(getPostedOnNow());
        pePipeResult.setMaterial("Материал на тръбата: PE");
        UserEntity userByUsername = this.userService.findUserByUsername(username);
        pePipeResult.setUser(userByUsername);
        return this.calculatorPipeResultRepository.save(pePipeResult).getId();
    }


    @Override
    public Long calculatePvcOPipe(PvcOPipeBindingModel pvcOPipeBindingModel, String username) {
        double internalDiameter = getPvcOPipeInternalDiameter(pvcOPipeBindingModel);
        if (internalDiameter == 0) {
            return -1L;
        }

        WaterTemperatureEnum waterTemperature = pvcOPipeBindingModel.getWaterTemperature();
        double kinematicViscosity = getKinematicViscosity(waterTemperature);

        CalculatorPipeResults pvcOPipeResults = HydroCalculator.calculatePipe(internalDiameter, pvcOPipeBindingModel.getFlowInLitersPerSeconds(),
                pvcOPipeBindingModel.getRoughnessHeightInMm(), pvcOPipeBindingModel.getLength(), kinematicViscosity);
        setWaterTemperature(waterTemperature, pvcOPipeResults);
        setDnAndPnOfPvcOPipe(pvcOPipeBindingModel, pvcOPipeResults);
        pvcOPipeResults.setCreatedOn(getPostedOnNow());
        pvcOPipeResults.setMaterial("Материал на тръбата: PVC-O");
        UserEntity userByUsername = this.userService.findUserByUsername(username);
        pvcOPipeResults.setUser(userByUsername);
        return this.calculatorPipeResultRepository.save(pvcOPipeResults).getId();
    }

    @Override
    public String getAvailableDiametersForPePipes(NominalPressure nominalPressure) {
        PePipeEnum[] values = PePipeEnum.values();
        String pipeMaterial = PePipeEnum.class.getName().split("\\.")[5].toUpperCase(Locale.ROOT).substring(0, 2);
        StringBuilder output = new StringBuilder();
        String format = String.format("Наличните диаметри за тръби %s и %s са: ", pipeMaterial, nominalPressure.name());
        switch (nominalPressure.name().toUpperCase(Locale.ROOT)) {
            case "PN10":
                for (PePipeEnum value : values) {
                    double dinPN10 = value.getDinPN10();
                    if (dinPN10 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
            case "PN16":
                for (PePipeEnum value : values) {
                    double dinPN16 = value.getDinPN16();
                    if (dinPN16 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
            case "PN20":
                for (PePipeEnum value : values) {
                    double dinPN20 = value.getDinPN20();
                    if (dinPN20 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
            case "PN25":
                for (PePipeEnum value : values) {
                    double dinPN25 = value.getDinPN25();
                    if (dinPN25 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
        }
        if (output.toString().trim().isBlank()) {
            return String.format("Не са налични тръби %s-O за %s", pipeMaterial, nominalPressure.name());
        }
        return format + output.substring(0, output.length() - 2).trim();
    }

    @Override
    public String getAvailableDiametersForPvcOPipes(NominalPressure nominalPressure) {
        StringBuilder output = new StringBuilder();
        PvcOPipeEnum[] values = PvcOPipeEnum.values();

        String pipeMaterial = PvcOPipeEnum.class.getName().split("\\.")[5].substring(0, 3).toUpperCase(Locale.ROOT);

        String format = String.format("Наличните диаметри за тръби %s-O и %s са: ", pipeMaterial, nominalPressure.name());
        switch (nominalPressure.name().toUpperCase(Locale.ROOT)) {
            case "PN16":
                for (PvcOPipeEnum value : values) {
                    double dinPN16 = value.getDinPn16();
                    if (dinPN16 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
            case "PN25":
                for (PvcOPipeEnum value : values) {
                    double dinPN25 = value.getDinPn25();
                    if (dinPN25 != 0) {
                        output.append(value.name()).append(", ");
                    }
                }
                break;
        }
        if (output.toString().trim().isBlank()) {
            return String.format("Не са налични тръби %s-O за %s", pipeMaterial, nominalPressure.name());
        }
        return format + output.substring(0, output.length() - 2).trim();
    }

    @Override
    public boolean removeCalculation(Long id) {
        CalculatorPipeResults calculatorPipeResults = this.calculatorPipeResultRepository.findById(id).orElse(null);
        if (calculatorPipeResults != null) {
            this.calculatorPipeResultRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOwnerOrAdmin(Principal principal, Long id) {
        String username = principal.getName();
        UserEntity caller = this.userService.findUserByUsername(username);
        Optional<CalculatorPipeResults> byId = this.calculatorPipeResultRepository.findById(id);
        if (byId.isEmpty() || caller == null) {
            return false;
        } else {
            UserEntity userWhoDidTheCalculation = byId.get().getUser();
            boolean isAdmin = this.userService.userIsAdmin(caller);
            return isAdmin || userWhoDidTheCalculation.getUsername().equalsIgnoreCase(username);
        }
    }

    private void setDnAndPnOfPvcOPipe(PvcOPipeBindingModel pvcOPipeBindingModel, CalculatorPipeResults pvcOPipeResults) {
        pvcOPipeResults.setPipeNominalDiameter(pvcOPipeBindingModel.getPvcOPipeEnum().name());
        pvcOPipeResults.setNominalPressure(pvcOPipeBindingModel.getNominalPressure().name());
    }

    private double getPvcOPipeInternalDiameter(PvcOPipeBindingModel pvcOPipeBindingModel) {
        NominalPressure nominalPressure = pvcOPipeBindingModel.getNominalPressure();
        double internalDiameter = 0.00;
        if (nominalPressure.equals(NominalPressure.PN16)) {
            internalDiameter = pvcOPipeBindingModel.getPvcOPipeEnum().getDinPn16();
        }
        if (nominalPressure.equals(NominalPressure.PN25)) {
            internalDiameter = pvcOPipeBindingModel.getPvcOPipeEnum().getDinPn25();
        }
        return internalDiameter;
    }

    private String getPostedOnNow() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int month = now.getMonth().getValue();
        int dayOfMonth = now.getDayOfMonth();
        return "Създаден на: " + dayOfMonth + "." + month;
    }

    private void setDnAndPn(PePipeBindingModel pePipeBindingModel, CalculatorPipeResults pePipeResult) {
        pePipeResult.setPipeNominalDiameter(pePipeBindingModel.getPePipeEnum().name());
        pePipeResult.setNominalPressure(pePipeBindingModel.getNominalPressure().name());
    }

    private double getPePipeInternalDiameter(PePipeBindingModel pePipeBindingModel) {
        NominalPressure nominalPressure = pePipeBindingModel.getNominalPressure();
        double internalDiameter = 0.00;
        if (nominalPressure.equals(NominalPressure.PN10)) {
            internalDiameter = pePipeBindingModel.getPePipeEnum().getDinPN10();
        }
        if (nominalPressure.equals(NominalPressure.PN16)) {
            internalDiameter = pePipeBindingModel.getPePipeEnum().getDinPN16();
        }
        if (nominalPressure.equals(NominalPressure.PN20)) {
            internalDiameter = pePipeBindingModel.getPePipeEnum().getDinPN20();
        }
        if (nominalPressure.equals(NominalPressure.PN25)) {
            internalDiameter = pePipeBindingModel.getPePipeEnum().getDinPN25();
        }
        return internalDiameter;
    }

    private double getKinematicViscosity(WaterTemperatureEnum waterTemperature) {
        double kinematicViscosity;
        if (waterTemperature == null) {
            kinematicViscosity = 0;
        } else {
            kinematicViscosity = waterTemperature.getKinematicViscosity();
        }
        return kinematicViscosity;
    }

    private void setWaterTemperature(WaterTemperatureEnum waterTemperature, CalculatorPipeResults calculatorPipeResults) {
        if (waterTemperature != null) {
            String degreesCelsius = waterTemperature.name().substring(1);
            calculatorPipeResults.setWaterTemperature("Температура на водата: " + degreesCelsius + CalculatorConstants.CELSIUS);
        } else {
            calculatorPipeResults.setWaterTemperature("Температура на водата: " + 10 + CalculatorConstants.CELSIUS);
        }
    }

}
