package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.CalculatorPipeResults;
import com.example.hydrocalc.repositrory.CalculatorPipeResultRepository;
import com.example.hydrocalc.services.CalcPipeResultService;
import org.springframework.stereotype.Service;

@Service
public class CalcPipeResultServiceImpl implements CalcPipeResultService {
    private final CalculatorPipeResultRepository calculatorPipeResultRepository;

    public CalcPipeResultServiceImpl(CalculatorPipeResultRepository calculatorPipeResultRepository) {
        this.calculatorPipeResultRepository = calculatorPipeResultRepository;
    }

    @Override
    public void addNewResult(CalculatorPipeResults result) {
        CalculatorPipeResults save = this.calculatorPipeResultRepository.save(result);

    }
}
