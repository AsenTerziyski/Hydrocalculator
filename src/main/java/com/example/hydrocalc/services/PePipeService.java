package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.PePipeEntity;
import com.example.hydrocalc.model.enums.NominalPressure;

import java.util.List;

public interface PePipeService {
    void initPePipes();

    List<PePipeEntity> findAllPePipes();

    PePipeEntity findPipeInternalDiameterByDN(String dn);

    boolean editPePipeDI(double di, String dn, NominalPressure pn);

    List<String> getPeCatalog();

}
