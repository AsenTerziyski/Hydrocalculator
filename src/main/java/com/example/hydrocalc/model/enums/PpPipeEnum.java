package com.example.hydrocalc.model.enums;

public enum PpPipeEnum {
    DN16(11.6, 10.6),
    DN20(14.4, 13.2),
    DN25(18, 16.6),
    DN32(23.2, 21.2),
    DN40(29, 26.6),
    DN50(36.2, 33.4),
    DN63(45.8, 42),
    DN75(54.4, 50),
    DN90(65.4, 60),
    DN110(79.8, 73.4);

    private double DinPN16;
    private double DinPN20;

    PpPipeEnum(double dinPN16, double dinPN20) {
        DinPN16 = dinPN16;
        DinPN20 = dinPN20;
    }

    public double getDinPN16() {
        return DinPN16;
    }

    public PpPipeEnum setDinPN16(double dinPN16) {
        DinPN16 = dinPN16;
        return this;
    }

    public double getDinPN20() {
        return DinPN20;
    }

    public PpPipeEnum setDinPN20(double dinPN20) {
        DinPN20 = dinPN20;
        return this;
    }

}
