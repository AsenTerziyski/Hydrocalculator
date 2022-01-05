package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.model.enums.PpPipeEnum;
import com.example.hydrocalc.model.enums.WaterTemperatureEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PpPipeBindingModel {
    private double flowInLitersPerSeconds;
    private double length;
    private double roughnessHeightInMm;
    private PpPipeEnum ppPipeEnum;
    private NominalPressure nominalPressure;
    private WaterTemperatureEnum waterTemperature;
    private String temperature;

    @Positive
    @NotNull
    public double getFlowInLitersPerSeconds() {
        return flowInLitersPerSeconds;
    }

    public PpPipeBindingModel setFlowInLitersPerSeconds(double flowInLitersPerSeconds) {
        this.flowInLitersPerSeconds = flowInLitersPerSeconds;
        return this;
    }

    @Positive
    @NotNull
    public double getLength() {
        return length;
    }

    public PpPipeBindingModel setLength(double length) {
        this.length = length;
        return this;
    }

    @Positive
    @NotNull
    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public PpPipeBindingModel setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }

    @Enumerated
    @NotNull
    public PpPipeEnum getPpPipeEnum() {
        return ppPipeEnum;
    }

    public PpPipeBindingModel setPpPipeEnum(PpPipeEnum ppPipeEnum) {
        this.ppPipeEnum = ppPipeEnum;
        return this;
    }

    @Enumerated
    @NotNull
    public NominalPressure getNominalPressure() {
        return nominalPressure;
    }

    public PpPipeBindingModel setNominalPressure(NominalPressure nominalPressure) {
        this.nominalPressure = nominalPressure;
        return this;
    }

    @Enumerated
    public WaterTemperatureEnum getWaterTemperature() {
        return waterTemperature;
    }

    public PpPipeBindingModel setWaterTemperature(WaterTemperatureEnum waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }

    @NotBlank
    @NotNull
    public String getTemperature() {
        return temperature;
    }

    public PpPipeBindingModel setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }
}
