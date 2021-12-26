package com.example.hydrocalc.calculator;

public class ReinoldsNumber {
    private final double kinematicViscosity;
    private final double velocityInMeterPerSecond;
    private final double internalDiameterInMm;

    protected ReinoldsNumber(double kinematicViscosity, double velocityInMeterPerSecond, double internalDiameterInMm) {
        this.kinematicViscosity = kinematicViscosity;
        this.velocityInMeterPerSecond = velocityInMeterPerSecond;
        this.internalDiameterInMm = internalDiameterInMm;
    }

    protected double getReinoldsNumber() {
        return (internalDiameterInMm / 1000) * velocityInMeterPerSecond / kinematicViscosity;
    }
}
