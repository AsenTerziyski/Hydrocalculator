package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.model.enums.WaterTemperatureEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

public class PePipeBindingModel {
    private double flowInLitersPerSeconds;
    private double length;
    private double roughnessHeightInMm;
    private PePipeEnum pePipeEnum;
    private NominalPressure nominalPressure;
    private WaterTemperatureEnum waterTemperature;
    private String temperature;

    @Positive
    public double getFlowInLitersPerSeconds() {
        return flowInLitersPerSeconds;
    }

    public PePipeBindingModel setFlowInLitersPerSeconds(double flowInLitersPerSeconds) {
        this.flowInLitersPerSeconds = flowInLitersPerSeconds;
        return this;
    }

    @Positive
    public double getLength() {
        return length;
    }

    public PePipeBindingModel setLength(double length) {
        this.length = length;
        return this;
    }

    @Positive
    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public PePipeBindingModel setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }

    @Enumerated
    @NotNull
    public PePipeEnum getPePipeEnum() {
        return pePipeEnum;
    }

    public PePipeBindingModel setPePipeEnum(PePipeEnum pePipeEnum) {
        this.pePipeEnum = pePipeEnum;
        return this;
    }

    @Enumerated
    @NotNull
    public NominalPressure getNominalPressure() {
        return nominalPressure;
    }

    public PePipeBindingModel setNominalPressure(NominalPressure nominalPressure) {
        this.nominalPressure = nominalPressure;
        return this;
    }

    @Enumerated
    public WaterTemperatureEnum getWaterTemperature() {
        return waterTemperature;
    }

    public PePipeBindingModel setWaterTemperature(WaterTemperatureEnum waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }

    @NotNull
    public String getTemperature() {
        return temperature;
    }

    public PePipeBindingModel setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }
}
