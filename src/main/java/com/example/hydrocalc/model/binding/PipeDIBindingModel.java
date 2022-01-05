package com.example.hydrocalc.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PipeDIBindingModel {
    private double flowInLitersPerSeconds;
    private double DI;
    private double length;
    private double roughnessHeightInMm;
    private String temperature;

    @Positive
    @NotNull
    public double getFlowInLitersPerSeconds() {
        return flowInLitersPerSeconds;
    }

    public PipeDIBindingModel setFlowInLitersPerSeconds(double flowInLitersPerSeconds) {
        this.flowInLitersPerSeconds = flowInLitersPerSeconds;
        return this;
    }

    @Positive
    @NotNull
    public double getDI() {
        return DI;
    }

    public PipeDIBindingModel setDI(double DI) {
        this.DI = DI;
        return this;
    }

    @Positive
    @NotNull
    public double getLength() {
        return length;
    }

    public PipeDIBindingModel setLength(double length) {
        this.length = length;
        return this;
    }

    @Positive
    @NotNull
    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public PipeDIBindingModel setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }

    @NotNull
    @NotBlank
    public String getTemperature() {
        return temperature;
    }

    public PipeDIBindingModel setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }
}
