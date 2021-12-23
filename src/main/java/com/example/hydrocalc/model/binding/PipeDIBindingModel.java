package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.WaterTemperatureEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Positive;

public class PipeDIBindingModel {
    private double flowInLitersPerSeconds;
    private double DI;
    private double length;
    private double roughnessHeightInMm;
    private WaterTemperatureEnum waterTemperature;

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

    @Enumerated
    public WaterTemperatureEnum getWaterTemperature() {
        return waterTemperature;
    }

    public PipeDIBindingModel setWaterTemperature(WaterTemperatureEnum waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }
}
