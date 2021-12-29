package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import com.example.hydrocalc.model.enums.NominalPressure;

public interface PvcOPipeService {
    void initPvcOPipes();

    PvcOPipeEntity findPvcoPipeInternalDiameterByDn(String dn);

    boolean editPvcOPipeDI(double di, String dn, NominalPressure pn);
}
