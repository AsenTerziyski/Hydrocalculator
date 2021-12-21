package com.example.hydrocalc.services;

import com.example.hydrocalc.model.binding.PePipeBindingModel;
import com.example.hydrocalc.model.binding.PvcOPipeBindingModel;
import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;

import java.security.Principal;
import java.util.List;

public interface CalcPipeResultService {

    void addNewResult(CalculatorPipeResults result);

    Long calculateByInternalDiameter(PipeDIBindingModel inputByInternalDiameter, String username);

    CalculatorPipeResultsModelView findResultById(Long savedResult);

    Long calculatePePipe(PePipeBindingModel pePipeBindingModel, String username);

    Long calculatePvcOPipe(PvcOPipeBindingModel pvcOPipeBindingModel, String username);

    String getAvailableDiametersForPePipes(NominalPressure nominalPressure);

    String getAvailableDiametersForPvcOPipes(NominalPressure nominalPressure);

    boolean removeCalculation(Long id);

    boolean isOwnerOrAdmin (Principal principal, Long id);

}
