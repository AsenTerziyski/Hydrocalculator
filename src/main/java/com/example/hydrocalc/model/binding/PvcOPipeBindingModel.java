package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.NominalPressure;
import com.example.hydrocalc.model.enums.PePipeEnum;
import com.example.hydrocalc.model.enums.PvcOPipeEnum;
import com.example.hydrocalc.model.enums.WaterTemperatureEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Positive;

public class PvcOPipeBindingModel {
    private double flowInLitersPerSeconds;
    private double length;
    private double roughnessHeightInMm;
    private PvcOPipeEnum pvcOPipeEnum;
    private NominalPressure nominalPressure;
    private WaterTemperatureEnum waterTemperature;

    @Positive
    public double getFlowInLitersPerSeconds() {
        return flowInLitersPerSeconds;
    }

    public PvcOPipeBindingModel setFlowInLitersPerSeconds(double flowInLitersPerSeconds) {
        this.flowInLitersPerSeconds = flowInLitersPerSeconds;
        return this;
    }

    @Positive
    public double getLength() {
        return length;
    }

    public PvcOPipeBindingModel setLength(double length) {
        this.length = length;
        return this;
    }

    @Positive
    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public PvcOPipeBindingModel setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }

    @Enumerated
    public PvcOPipeEnum getPvcOPipeEnum() {
        return pvcOPipeEnum;
    }

    public PvcOPipeBindingModel setPvcOPipeEnum(PvcOPipeEnum pvcOPipeEnum) {
        this.pvcOPipeEnum = pvcOPipeEnum;
        return this;
    }



    @Enumerated
//    @NotNull
    public NominalPressure getNominalPressure() {
        return nominalPressure;
    }

    public PvcOPipeBindingModel setNominalPressure(NominalPressure nominalPressure) {
        this.nominalPressure = nominalPressure;
        return this;
    }

    @Enumerated
    public WaterTemperatureEnum getWaterTemperature() {
        return waterTemperature;
    }

    public PvcOPipeBindingModel setWaterTemperature(WaterTemperatureEnum waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }
}
