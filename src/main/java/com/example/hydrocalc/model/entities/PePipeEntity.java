package com.example.hydrocalc.model.entities;

import javax.persistence.Entity;

@Entity
public class PePipeEntity extends BaseEntity {
    private String Dn;
    private double DinPN10;
    private double DinPN16;
    private double DinPN20;
    private double DinPN25;

    public String getDn() {
        return Dn;
    }

    public PePipeEntity setDn(String dn) {
        Dn = dn;
        return this;
    }

    public double getDinPN10() {
        return DinPN10;
    }

    public PePipeEntity setDinPN10(double dinPN10) {
        DinPN10 = dinPN10;
        return this;
    }

    public double getDinPN16() {
        return DinPN16;
    }

    public PePipeEntity setDinPN16(double dinPN16) {
        DinPN16 = dinPN16;
        return this;
    }

    public double getDinPN20() {
        return DinPN20;
    }

    public PePipeEntity setDinPN20(double dinPN20) {
        DinPN20 = dinPN20;
        return this;
    }

    public double getDinPN25() {
        return DinPN25;
    }

    public PePipeEntity setDinPN25(double dinPN25) {
        DinPN25 = dinPN25;
        return this;
    }
}
