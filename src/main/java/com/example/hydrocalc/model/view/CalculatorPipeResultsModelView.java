package com.example.hydrocalc.model.view;

public class CalculatorPipeResultsModelView {
    private Long id;
    private double flowInLitersPerSecond;
    private String pipeNominalDiameter;
    private double pipeInternalDiameter;
    private String  nominalPressure;
    private double pipeTotalLength;
    private double velocityInMetersPerSecond;
    private double roughnessHeightInMm;
    private double lossesPerMeter;
    private double totalLosses;
    private boolean velocityHigh;
    private boolean velocityLow;
    private boolean canDelete;
    private String createdOn;


    public Long getId() {
        return id;
    }

    public CalculatorPipeResultsModelView setId(Long id) {
        this.id = id;
        return this;
    }

    public double getFlowInLitersPerSecond() {
        return flowInLitersPerSecond;
    }

    public CalculatorPipeResultsModelView setFlowInLitersPerSecond(double flowInLitersPerSecond) {
        this.flowInLitersPerSecond = flowInLitersPerSecond;
        return this;
    }

    public String getPipeNominalDiameter() {
        return pipeNominalDiameter;
    }

    public CalculatorPipeResultsModelView setPipeNominalDiameter(String pipeNominalDiameter) {
        this.pipeNominalDiameter = pipeNominalDiameter;
        return this;
    }

    public double getPipeInternalDiameter() {
        return pipeInternalDiameter;
    }

    public CalculatorPipeResultsModelView setPipeInternalDiameter(double pipeInternalDiameter) {
        this.pipeInternalDiameter = pipeInternalDiameter;
        return this;
    }

    public String getNominalPressure() {
        return nominalPressure;
    }

    public CalculatorPipeResultsModelView setNominalPressure(String nominalPressure) {
        this.nominalPressure = nominalPressure;
        return this;
    }

    public double getPipeTotalLength() {
        return pipeTotalLength;
    }

    public CalculatorPipeResultsModelView setPipeTotalLength(double pipeTotalLength) {
        this.pipeTotalLength = pipeTotalLength;
        return this;
    }

    public double getVelocityInMetersPerSecond() {
        return velocityInMetersPerSecond;
    }

    public CalculatorPipeResultsModelView setVelocityInMetersPerSecond(double velocityInMetersPerSecond) {
        this.velocityInMetersPerSecond = velocityInMetersPerSecond;
        return this;
    }

    public double getRoughnessHeightInMm() {
        return roughnessHeightInMm;
    }

    public CalculatorPipeResultsModelView setRoughnessHeightInMm(double roughnessHeightInMm) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        return this;
    }

    public double getLossesPerMeter() {
        return lossesPerMeter;
    }

    public CalculatorPipeResultsModelView setLossesPerMeter(double lossesPerMeter) {
        this.lossesPerMeter = lossesPerMeter;
        return this;
    }

    public double getTotalLosses() {
        return totalLosses;
    }

    public CalculatorPipeResultsModelView setTotalLosses(double totalLosses) {
        this.totalLosses = totalLosses;
        return this;
    }

    public boolean isVelocityHigh() {
        return velocityHigh;
    }

    public CalculatorPipeResultsModelView setVelocityHigh(boolean velocityHigh) {
        this.velocityHigh = velocityHigh;
        return this;
    }

    public boolean isVelocityLow() {
        return velocityLow;
    }

    public CalculatorPipeResultsModelView setVelocityLow(boolean velocityLow) {
        this.velocityLow = velocityLow;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public CalculatorPipeResultsModelView setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public CalculatorPipeResultsModelView setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }
}
