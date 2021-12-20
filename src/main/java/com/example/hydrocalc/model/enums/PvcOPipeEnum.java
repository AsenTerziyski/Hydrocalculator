package com.example.hydrocalc.model.enums;

public enum PvcOPipeEnum {
    DN90(84,82.2),
    DN110(104,101.4),
    DN140(132.4,129.2),
    DN160(151.4,147.6),
    DN200(189.2,184.4),
    DN225(212.8,207.4),
    DN250(236.4,230.6),
    DN315(298,290.6),
    DN355(336,327.2),
    DN400(378.4,369),
    DN450(426,415),
    DN500(472.8,461.2),
    DN630(595.8,581),
    DN710(671.4,0),
    DN800(757.8,0);

    private double DinPn16;
    private double DinPn25;

    PvcOPipeEnum(double dinPn16, double dinPn25) {
        DinPn16 = dinPn16;
        DinPn25 = dinPn25;
    }

    public double getDinPn16() {
        return DinPn16;
    }

    public PvcOPipeEnum setDinPn16(double dinPn16) {
        DinPn16 = dinPn16;
        return this;
    }

    public double getDinPn25() {
        return DinPn25;
    }

    public PvcOPipeEnum setDinPn25(double dinPn25) {
        DinPn25 = dinPn25;
        return this;
    }
}
