package com.example.hydrocalc.model.entities;

import javax.persistence.Entity;

@Entity
public class PvcoPipeEntity extends BaseEntity {
    private String dn;
    private double DinPn16;
    private double DinPn25;

    public String getDn() {
        return dn;
    }

    public PvcoPipeEntity setDn(String dn) {
        this.dn = dn;
        return this;
    }

    public double getDinPn16() {
        return DinPn16;
    }

    public PvcoPipeEntity setDinPn16(double dinPn16) {
        DinPn16 = dinPn16;
        return this;
    }

    public double getDinPn25() {
        return DinPn25;
    }

    public PvcoPipeEntity setDinPn25(double dinPn25) {
        DinPn25 = dinPn25;
        return this;
    }
}
