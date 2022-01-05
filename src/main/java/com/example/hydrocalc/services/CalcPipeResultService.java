package com.example.hydrocalc.services;

import com.example.hydrocalc.model.binding.PePipeBindingModel;
import com.example.hydrocalc.model.binding.PpPipeBindingModel;
import com.example.hydrocalc.model.binding.PvcOPipeBindingModel;
import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;

import java.security.Principal;
import java.util.List;
import java.util.Set;

public interface CalcPipeResultService {

    Long addNewResult(CalculatorPipeResults result, String username);



    CalculatorPipeResultsModelView findResultById(Long savedResult);

    Long calculateByInternalDiameter(PipeDIBindingModel inputByInternalDiameter, String username);

    Long calculatePePipe(PePipeBindingModel pePipeBindingModel, String username);

    Long calculatePvcOPipe(PvcOPipeBindingModel pvcOPipeBindingModel, String username);

    Long calculatePpPipe(PpPipeBindingModel ppPipeBindingModel, String username);



    String getAvailableDiametersForPePipes(NominalPressure nominalPressure);

    String getAvailableDiametersForPvcOPipes(NominalPressure nominalPressure);

    boolean removeCalculation(Long id);

    boolean isOwnerOrAdmin(Principal principal, Long id);

    Set<String> getTemperatureSet();

    void delete30daysOldRecords();

    String getAvailableDiametersForPpPipes(NominalPressure nominalPressure);
}
