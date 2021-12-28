package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import com.example.hydrocalc.model.enums.PvcOPipeEnum;
import com.example.hydrocalc.repositrory.PvcOPipeRepository;
import com.example.hydrocalc.services.PvcOPipeService;
import org.springframework.stereotype.Service;

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

    private void setDiameters(PvcOPipeEnum value, PvcOPipeEntity pvcOPipeEntity) {
        pvcOPipeEntity
                .setDinPn16(value.getDinPn16())
                .setDinPn25(value.getDinPn25())
                .setDn(value.name());
    }
}
