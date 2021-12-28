package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.PePipeEntity;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.repositrory.PePipeRepository;
import com.example.hydrocalc.services.PePipeService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PePipeServiceImpl implements PePipeService {

    private final PePipeRepository pePipeRepository;

    public PePipeServiceImpl(PePipeRepository pePipeRepository) {
        this.pePipeRepository = pePipeRepository;
    }

    @Override
    public void initPePipes() {
        if (this.pePipeRepository.count() == 0) {
            PePipeEnum[] values = PePipeEnum.values();
            for (PePipeEnum value : values) {
                PePipeEntity pePipeEntity = new PePipeEntity();
                String dn = value.name();
                switch (dn.toUpperCase(Locale.ROOT)) {
                    case "DN20":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN25":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN32":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN40":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN50":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN63":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN75":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;

                    case "DN90":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN110":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN125":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN140":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN160":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN180":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN200":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN225":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN250":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN280":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN315":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN355":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN400":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN450":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN500":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN560":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                    case "DN630":
                        pePipeEntity
                                .setDn(value.name())
                                .setDinPN10(value.getDinPN10())
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20())
                                .setDinPN25(value.getDinPN25());
                        break;
                }
                this.pePipeRepository.save(pePipeEntity);
            }
        }
    }
}
