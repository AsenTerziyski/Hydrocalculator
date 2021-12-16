package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;

public interface CalcPipeResultService {
    void addNewResult(CalculatorPipeResults result);


    Long calculateByInternalDiameter(PipeDIBindingModel inputByInternalDiameter);

    CalculatorPipeResultsModelView findResultById(Long savedResult);
}
