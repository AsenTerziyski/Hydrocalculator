package com.example.hydrocalc.calculator;

public class SwamiJaneEquation {
    private double roughnessHeightInMm;
    private double internalDiameterInMm;
    private double rNumber;

    protected SwamiJaneEquation(double roughnessHeightInMm, double internalDiameterInMm, double rNumber) {
        this.roughnessHeightInMm = roughnessHeightInMm;
        this.internalDiameterInMm = internalDiameterInMm;
        this.rNumber = rNumber;
    }

    protected double getFrictionLossesInMeterPerMeter() {
        double intermediateVariable = Math.log10((roughnessHeightInMm / 1000) / (3.7 * internalDiameterInMm / 1000) + 5.74 / Math.pow(rNumber, 0.9));
        return 0.25 / Math.pow(intermediateVariable, 2);
    }
}
