package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.PpPipeEntity;
import com.example.hydrocalc.model.enums.PpPipeEnum;

import java.util.List;

public interface PpPipeService {
    void initPpPipes();

    PpPipeEntity findPpPipeInternalDiameterByDn(PpPipeEnum ppPipeEnum);

    List<String> getPpCatalog();

}
