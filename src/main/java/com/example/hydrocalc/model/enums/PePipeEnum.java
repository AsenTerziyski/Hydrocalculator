package com.example.hydrocalc.model.enums;

public enum PePipeEnum {
    DN90(89.1, 88.2),
    DN110(90, 89),
    DN125(110.1, 100.5);

    private double DinPN10;
    private double DinPN16;

    PePipeEnum(double dinPN10, double dinPN16) {
        DinPN10 = dinPN10;
        DinPN16 = dinPN16;
    }

    public double getDinPN10() {
        return DinPN10;
    }

    public PePipeEnum setDinPN10(double dinPN10) {
        DinPN10 = dinPN10;
        return this;
    }

    public double getDinPN16() {
        return DinPN16;
    }

    public PePipeEnum setDinPN16(double dinPN16) {
        DinPN16 = dinPN16;
        return this;
    }
}
