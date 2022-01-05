package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.PpPipeEntity;
import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import com.example.hydrocalc.model.enums.PpPipeEnum;
import com.example.hydrocalc.repositrory.PpPipeRepository;
import com.example.hydrocalc.services.PpPipeService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
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
                PpPipeEntity pp = new PpPipeEntity();
                String name = value.name();
                switch (value.name().toUpperCase(Locale.ROOT)) {
                    case "DN16":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN20":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN25":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN32":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN40":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN50":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN63":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN75":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN90":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                    case "DN110":
                        pp
                                .setDn(value.name().toUpperCase(Locale.ROOT))
                                .setDinPN16(value.getDinPN16())
                                .setDinPN20(value.getDinPN20());
                        break;
                }
                this.ppPipeRepository.save(pp);
            }
        }
    }

    @Override
    public PpPipeEntity findPpPipeInternalDiameterByDn(PpPipeEnum ppPipeEnum) {
        PpPipeEntity byDn = this.ppPipeRepository.findByDn(ppPipeEnum.name());
        if (byDn != null) {
            return byDn;
        }
        return null;
    }

    @Override
    public List<String> getPpCatalog() {
        List<PpPipeEntity> all = this.ppPipeRepository.findAll();
        List<String> ppCatalog = new LinkedList<>();
//        List<PvcOPipeEntity> all = this.pvcOPipeRepository.findAll();
//        List<String> pvcOCatalog = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (PpPipeEntity ppPipeEntity : all) {
            String dn = ppPipeEntity.getDn();
            double dinPn16 = ppPipeEntity.getDinPN16();
            double dinPn20 = ppPipeEntity.getDinPN20();

            i++;
            sb.append("2." + i + ". " + dn + ": ");
            if (dinPn16 > 0) {
                sb.append("[ PN16 - DI=" + dinPn16 + " ], ").append(System.lineSeparator());
            }
            if (dinPn20> 0) {
                sb.append("[ PN20 - DI=" + dinPn20 + " ], ").append(System.lineSeparator());
            }
            sb.append(System.lineSeparator());
            ppCatalog.add(sb.toString().trim().substring(0, sb.toString().trim().length() - 1));
            sb = new StringBuilder();
        }
        return ppCatalog;
    }
}
