package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.enums.PpPipeEnum;
import com.example.hydrocalc.repositrory.PpPipeRepository;
import com.example.hydrocalc.services.PpPipeService;

public class PpPipeServiceImpl implements PpPipeService {
    private final PpPipeRepository ppPipeRepository;

    public PpPipeServiceImpl(PpPipeRepository ppPipeRepository) {
        this.ppPipeRepository = ppPipeRepository;
    }

    @Override
    public void initPpPipes() {
        if (this.ppPipeRepository.count() == 0) {
            PpPipeEnum[] values = PpPipeEnum.values();
            for (PpPipeEnum value : values) {
                String name = value.name();
                //todo
            }
        }
    }
}
