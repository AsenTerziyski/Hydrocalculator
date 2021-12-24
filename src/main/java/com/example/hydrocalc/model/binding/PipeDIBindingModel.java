package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.WaterTemperatureEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

public class PipeDIBindingModel {
    private double flowInLitersPerSeconds;
    private double DI;
    private double length;
    private double roughnessHeightInMm;
    private Set<String> temperatures;

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

    @Size(min = 1, max = 1)
    public Set<String> getTemperatures() {
        return temperatures;
    }

    public PipeDIBindingModel setTemperatures(Set<String> temperatures) {
        this.temperatures = temperatures;
        return this;
    }
}
