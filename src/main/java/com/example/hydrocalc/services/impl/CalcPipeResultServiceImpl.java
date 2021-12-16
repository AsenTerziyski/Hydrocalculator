package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.calculator.HydroCalculator;
import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.repositrory.CalculatorPipeResultRepository;
import com.example.hydrocalc.services.CalcPipeResultService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CalcPipeResultServiceImpl implements CalcPipeResultService {
    private final CalculatorPipeResultRepository calculatorPipeResultRepository;
    private final ModelMapper modelMapper;

    public CalcPipeResultServiceImpl(CalculatorPipeResultRepository calculatorPipeResultRepository, ModelMapper modelMapper) {
        this.calculatorPipeResultRepository = calculatorPipeResultRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewResult(CalculatorPipeResults result) {
        CalculatorPipeResults save = this.calculatorPipeResultRepository.save(result);

    }

    @Override
    public Long calculateByInternalDiameter(PipeDIBindingModel inputByInternalDiameter) {
        double di = inputByInternalDiameter.getDI();
        double flowInLitersPerSeconds = inputByInternalDiameter.getFlowInLitersPerSeconds();
        double length = inputByInternalDiameter.getLength();
        double roughnessHeightInMm = inputByInternalDiameter.getRoughnessHeightInMm();
        System.out.println();
        CalculatorPipeResults calculatorPipeResults = HydroCalculator.calculatePipe(di, flowInLitersPerSeconds, roughnessHeightInMm, length);
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

}
