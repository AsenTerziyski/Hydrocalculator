package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PipeMaterialsEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PipeEditInternalDiameterBindingModel {
    private double DI;
    private NominalPressure PN;
    private String DN;
    private PipeMaterialsEnum pipeMaterial;

    @NotNull
    @Positive
    public double getDI() {
        return DI;
    }

    public PipeEditInternalDiameterBindingModel setDI(double DI) {
        this.DI = DI;
        return this;
    }

    @NotNull
    @Enumerated
    public NominalPressure getPN() {
        return PN;
    }

    public PipeEditInternalDiameterBindingModel setPN(NominalPressure PN) {
        this.PN = PN;
        return this;
    }

    @NotBlank
    @Enumerated
    public String getDN() {
        return DN;
    }

    public PipeEditInternalDiameterBindingModel setDN(String DN) {
        this.DN = DN;
        return this;
    }

    @NotNull
    @Enumerated
    public PipeMaterialsEnum getPipeMaterial() {
        return pipeMaterial;
    }

    public PipeEditInternalDiameterBindingModel setPipeMaterial(PipeMaterialsEnum pipeMaterial) {
        this.pipeMaterial = pipeMaterial;
        return this;
    }
}
