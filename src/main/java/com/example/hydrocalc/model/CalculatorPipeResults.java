package com.example.hydrocalc.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CalculatorPipeResults extends BaseEntity {


    private double flowInLitersPerSecond;
    private String pipeNominalDiameter;
    private double pipeInternalDiameter;
    private String  nominalPressure;
    private double pipeTotalLength;
    private double velocityInMetersPerSecond;
    private double roughnessHeightInMeters;
    private double lossesPerMeter;
    private double totalLosses;


    public double getFlowInLitersPerSecond() {
        return flowInLitersPerSecond;
    }

    public CalculatorPipeResults setFlowInLitersPerSecond(double flowInLitersPerSecond) {
        this.flowInLitersPerSecond = flowInLitersPerSecond;
        return this;
    }

    public String getPipeNominalDiameter() {
        return pipeNominalDiameter;
    }

    public CalculatorPipeResults setPipeNominalDiameter(String pipeNominalDiameter) {
        this.pipeNominalDiameter = pipeNominalDiameter;
        return this;
    }

    public double getPipeInternalDiameter() {
        return pipeInternalDiameter;
    }

    public CalculatorPipeResults setPipeInternalDiameter(double pipeInternalDiameter) {
        this.pipeInternalDiameter = pipeInternalDiameter;
        return this;
    }

    public double getPipeTotalLength() {
        return pipeTotalLength;
    }

    public CalculatorPipeResults setPipeTotalLength(double pipeTotalLength) {
        this.pipeTotalLength = pipeTotalLength;
        return this;
    }

    public double getVelocityInMetersPerSecond() {
        return velocityInMetersPerSecond;
    }

    public CalculatorPipeResults setVelocityInMetersPerSecond(double velocityInMetersPerSecond) {
        this.velocityInMetersPerSecond = velocityInMetersPerSecond;
        return this;
    }

    public double getRoughnessHeightInMeters() {
        return roughnessHeightInMeters;
    }

    public CalculatorPipeResults setRoughnessHeightInMeters(double roughnessHeightInMeters) {
        this.roughnessHeightInMeters = roughnessHeightInMeters;
        return this;
    }

    public double getLossesPerMeter() {
        return lossesPerMeter;
    }

    public CalculatorPipeResults setLossesPerMeter(double lossesPerMeter) {
        this.lossesPerMeter = lossesPerMeter;
        return this;
    }

    public double getTotalLosses() {
        return totalLosses;
    }

    public CalculatorPipeResults setTotalLosses(double totalLosses) {
        this.totalLosses = totalLosses;
        return this;
    }

    public String getNominalPressure() {
        return nominalPressure;
    }

    public CalculatorPipeResults setNominalPressure(String nominalPressure) {
        this.nominalPressure = nominalPressure;
        return this;
    }

}
