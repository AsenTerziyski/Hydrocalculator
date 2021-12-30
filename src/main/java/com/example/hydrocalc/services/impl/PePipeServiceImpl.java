package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.PePipeEntity;
import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.repositrory.PePipeRepository;
import com.example.hydrocalc.services.PePipeService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
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

    @Override
    public List<PePipeEntity> findAllPePipes() {
        return this.pePipeRepository.findAll();
    }

    @Override
    public PePipeEntity findPipeInternalDiameterByDN(String dn) {
        return this.pePipeRepository.findByDn(dn);
    }

    @Override
    public boolean editPePipeDI(double di, String dn, NominalPressure pn) {
        PePipeEntity byDn = this.pePipeRepository.findByDn(dn);
        if (byDn != null) {
            switch (pn.name().toUpperCase(Locale.ROOT)) {
                case "PN10":
                    byDn.setDinPN10(di);
                    break;
                case "PN16":
                    byDn.setDinPN16(di);
                    break;
                case "PN20":
                    byDn.setDinPN20(di);
                    break;
                case "PN25":
                    byDn.setDinPN25(di);
                    break;
                default:
                    return false;
            }
            this.pePipeRepository.save(byDn);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getPeCatalog() {
        List<PePipeEntity> all = this.pePipeRepository.findAll();
        List<String> peCatalog = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (PePipeEntity pePipeEntity : all) {
            String dn = pePipeEntity.getDn();
            double dinPN10 = pePipeEntity.getDinPN10();
            double dinPN16 = pePipeEntity.getDinPN16();
            double dinPN20 = pePipeEntity.getDinPN20();
            i++;
            sb.append("1." + i + ". " + dn + ": ");
            if (dinPN10 > 0) {
                sb.append("[ PN10 - DI=" + dinPN10 + " ], ").append(System.lineSeparator());
            }
            if (dinPN16 > 0) {
                sb.append("[ PN16 - DI=" + dinPN16 + " ], ").append(System.lineSeparator());
            }
            if (dinPN20 > 0) {
                sb.append("[ PN20 - DI=" + dinPN20 + " ], ").append(System.lineSeparator());
            }
            sb.append(System.lineSeparator());
            peCatalog.add(sb.toString().trim().substring(0, sb.toString().trim().length() - 1));
            sb = new StringBuilder();
        }
        return peCatalog;
    }
}
