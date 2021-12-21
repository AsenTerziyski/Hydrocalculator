package com.example.hydrocalc.model.binding;

import javax.validation.constraints.Positive;

public class PipeDIBindingModel {
    private double flowInLitersPerSeconds;
    private double DI;
    private double length;
    private double roughnessHeightInMm;

    @Positive
    public double getFlowInLitersPerSeconds() {
        return flowInLitersPerSeconds;
    }

    public PipeDIBindingModel setFlowInLitersPerSeconds(double flowInLitersPerSeconds) {
        this.flowInLitersPerSeconds = flowInLitersPerSeconds;
        return this;
    }

    @Positive
    public double getDI() {
        return DI;
    }

    public PipeDIBindingModel setDI(double DI) {
        this.DI = DI;
        return this;
    }

    @Positive
    public double getLength() {
        return length;
    }

    public PipeDIBindingModel setLength(double length) {
        this.length = length;
        return this;
    }

    @Positive
    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public PipeDIBindingModel setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }
}
