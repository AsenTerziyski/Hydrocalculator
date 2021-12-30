package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import com.example.hydrocalc.model.enums.NominalPressure;

import java.util.List;

public interface PvcOPipeService {
    void initPvcOPipes();

    PvcOPipeEntity findPvcoPipeInternalDiameterByDn(String dn);

    boolean editPvcOPipeDI(double di, String dn, NominalPressure pn);

    List<String> getPvcoCatalog();

}
