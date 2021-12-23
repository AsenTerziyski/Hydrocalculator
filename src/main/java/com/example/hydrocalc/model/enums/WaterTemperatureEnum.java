package com.example.hydrocalc.model.enums;

import java.util.LinkedList;
import java.util.List;

public enum WaterTemperatureEnum {
    C10(1.3065 * Math.pow(10, -6)),
    C20(1.0035 * Math.pow(10, -6)),
    C50(0.5531 * Math.pow(10, -6)),
    C60(0.4740 * Math.pow(10, -6)),
    C70(0.4127 * Math.pow(10, -6));


    private double kinematicViscosity;
//    private static final String WATER_TEMP = "C"+ (char) 176;

    WaterTemperatureEnum(double kinematicViscosity) {
        this.kinematicViscosity = kinematicViscosity;
    }

    public double getKinematicViscosity() {
        return kinematicViscosity;
    }

    public WaterTemperatureEnum setKinematicViscosity(double kinematicViscosity) {
        this.kinematicViscosity = kinematicViscosity;
        return this;
    }

//    public List<String> list() {
////        return WaterTemperatureEnum.WATER_TEMP + WaterTemperatureEnum.C10 ;
//        List<String> values = new LinkedList<>();
//        WaterTemperatureEnum[] rawValues= WaterTemperatureEnum.values();
//        for (WaterTemperatureEnum rawValue : rawValues) {
//            String substring = rawValue.name().substring(1, rawValue.name().length() - 1);
//            values.add(substring + WATER_TEMP);
//        }
//        return values;
//    }
}
