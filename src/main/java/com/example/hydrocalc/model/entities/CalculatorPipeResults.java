package com.example.hydrocalc.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class CalculatorPipeResults extends BaseEntity {

    private double flowInLitersPerSecond;
    private String pipeNominalDiameter;
    private double pipeInternalDiameter;
    private String  nominalPressure;
    private double pipeTotalLength;
    private double velocityInMetersPerSecond;
    private double roughnessHeightInMm;
    private double lossesPerMeter;
    private double totalLosses;
    private String createdOn;
    private String waterTemperature;
    private boolean velocityHigh;
    private boolean velocityLow;
    private String material;
    private UserEntity user;



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

    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public CalculatorPipeResults setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public CalculatorPipeResults setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public boolean isVelocityHigh() {
        return velocityHigh;
    }

    public CalculatorPipeResults setVelocityHigh(boolean velocityHigh) {
        this.velocityHigh = velocityHigh;
        return this;
    }

    public boolean isVelocityLow() {
        return velocityLow;
    }

    public CalculatorPipeResults setVelocityLow(boolean velocityLow) {
        this.velocityLow = velocityLow;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public CalculatorPipeResults setMaterial(String material) {
        this.material = material;
        return this;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public CalculatorPipeResults setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getWaterTemperature() {
        return waterTemperature;
    }

    public CalculatorPipeResults setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }
}
