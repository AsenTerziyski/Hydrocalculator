package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.PePipeEntity;
import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PvcOPipeEnum;
import com.example.hydrocalc.repositrory.PvcOPipeRepository;
import com.example.hydrocalc.services.PvcOPipeService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class PvcOPipeServiceImpl implements PvcOPipeService {
    private final PvcOPipeRepository pvcOPipeRepository;

    public PvcOPipeServiceImpl(PvcOPipeRepository pvcOPipeRepository) {
        this.pvcOPipeRepository = pvcOPipeRepository;
    }

    @Override
    public void initPvcOPipes() {
        if (this.pvcOPipeRepository.count() == 0) {
            PvcOPipeEnum[] values = PvcOPipeEnum.values();
            for (PvcOPipeEnum value : values) {
                PvcOPipeEntity pvcOPipeEntity = new PvcOPipeEntity();
                String dn = value.name();
                switch (dn.toUpperCase(Locale.ROOT)) {
                    case "DN90":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN110":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN140":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN160":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN200":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN225":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN250":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN315":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN355":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN400":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN450":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN500":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN630":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN710":
                        setDiameters(value, pvcOPipeEntity);
                        break;
                    case "DN800":
                        setDiameters(value, pvcOPipeEntity);
                        break;

                }
                this.pvcOPipeRepository.save(pvcOPipeEntity);
            }
        }
    }

    @Override
    public PvcOPipeEntity findPvcoPipeInternalDiameterByDn(String dn) {
        return this.pvcOPipeRepository.findByDn(dn);
    }

    @Override
    public boolean editPvcOPipeDI(double di, String dn, NominalPressure pn) {
        PvcOPipeEntity byDn = this.pvcOPipeRepository.findByDn(dn);
        if (byDn != null) {
            switch (pn.name().toUpperCase(Locale.ROOT)) {
                case "PN16":
                    byDn.setDinPn16(di);
                    break;
                case "PN25":
                    byDn.setDinPn25(di);
                    break;
                default: return false;
            }
            this.pvcOPipeRepository.save(byDn);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getPvcoCatalog() {
        List<PvcOPipeEntity> all = this.pvcOPipeRepository.findAll();
        List<String> pvcOCatalog = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (PvcOPipeEntity pvcOPipeEntity : all) {
            String dn = pvcOPipeEntity.getDn();
            double dinPn16 = pvcOPipeEntity.getDinPn16();
            double dinPn25 = pvcOPipeEntity.getDinPn25();


            i++;
            sb.append("2." + i + ". " + dn + ": ");
            if (dinPn16 > 0) {
                sb.append("[ PN16 - DI=" + dinPn16 + " ], ").append(System.lineSeparator());
            }
            if (dinPn25> 0) {
                sb.append("[ PN25 - DI=" + dinPn25 + " ], ").append(System.lineSeparator());
            }
            sb.append(System.lineSeparator());
            pvcOCatalog.add(sb.toString().trim().substring(0, sb.toString().trim().length() - 1));
            sb = new StringBuilder();
        }
        return pvcOCatalog;
    }

    private void setDiameters(PvcOPipeEnum value, PvcOPipeEntity pvcOPipeEntity) {
        pvcOPipeEntity
                .setDinPn16(value.getDinPn16())
                .setDinPn25(value.getDinPn25())
                .setDn(value.name());
    }
}
