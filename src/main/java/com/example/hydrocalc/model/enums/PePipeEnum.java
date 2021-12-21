package com.example.hydrocalc.model.enums;

public enum PePipeEnum {

    DN20(0,16,0,14),
    DN25(0,20.4,0,18),
    DN32(28, 26, 24.8,23.2),
    DN40(35.2, 32.6, 31,29),
    DN50(44, 40.8, 38.8,36.2),
    DN63(55.4, 51.4, 48.8,45.8),
    DN75(66, 61.4, 58.2,54.4),
    DN90(79.2, 73.6, 69.8,65.4),
    DN110(96.8, 90, 85.4,79.8),
    DN125(110.2, 102.2, 97,90.8),
    DN140(123.4, 114.6, 108.6,101.6),
    DN160(141, 130.8, 124.2,116.2),
    DN180(158.6, 147.2, 139.8,130.8),
    DN200(176.2, 163.6, 155.2,145.2),
    DN225(198.2, 184, 174.6,163.4),
    DN250(220.4, 204.6, 194.2,181.6),
    DN280(246.8, 229.2, 217.4,203.4),
    DN315(277.6, 257.8, 244.6,228.8),
    DN355(312.8, 290.6, 275.6,258),
    DN400(352.6, 327.4, 310.6,290.6),
    DN450(396.6, 368.2, 349.4,327),
    DN500(440.6, 409.2, 0,0),
    DN560(493.6, 458.4, 0,0),
    DN630(555.2, 515.6, 0,0);

    private double DinPN10;
    private double DinPN16;
    private double DinPN20;
    private double DinPN25;

    PePipeEnum(double dinPN10, double dinPN16, double dinPN20, double dinPN25) {
        DinPN10 = dinPN10;
        DinPN16 = dinPN16;
        DinPN20 = dinPN20;
        DinPN25 = dinPN25;
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

    public double getDinPN20() {
        return DinPN20;
    }

    public PePipeEnum setDinPN20(double dinPN20) {
        DinPN20 = dinPN20;
        return this;
    }

    public double getDinPN25() {
        return DinPN25;
    }

    public PePipeEnum setDinPN25(double dinPN25) {
        DinPN25 = dinPN25;
        return this;
    }
}
