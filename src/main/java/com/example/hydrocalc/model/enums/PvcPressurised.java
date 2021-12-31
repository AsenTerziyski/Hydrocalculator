package com.example.hydrocalc.model.enums;

public enum PvcPressurised {
    DN50(45.2,0),
    DN63(57,0),
    DN75(67.8,0),
    DN90(81.4,76.6),
    DN110(99.4,93.6),
    DN125(113.0,106.4),
    DN140(126.6,119.2),
    DN160(144.6,136.2),
    DN200(180.8,170.2),
    DN225(203.4,191.6),
    DN250(226.2,212.8),
    DN280(253.2,238.4),
    DN315(285,268.2),
    DN355(321.2,302.4),
    DN400(361.8,340.6),
    DN450(407,0),
    DN500(452.2,0);

    private double DinPN10;
    private double DinPN26;

    PvcPressurised(double dinPN10, double dinPN26) {
        DinPN10 = dinPN10;
        DinPN26 = dinPN26;
    }

    public double getDinPN10() {
        return DinPN10;
    }

    public PvcPressurised setDinPN10(double dinPN10) {
        DinPN10 = dinPN10;
        return this;
    }

    public double getDinPN26() {
        return DinPN26;
    }

    public PvcPressurised setDinPN26(double dinPN26) {
        DinPN26 = dinPN26;
        return this;
    }
}
