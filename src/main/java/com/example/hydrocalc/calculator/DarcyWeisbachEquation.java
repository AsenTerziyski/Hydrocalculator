package com.example.hydrocalc.calculator;

public class DarcyWeisbachEquation {
    private final double frictionFactor;
    private final double internalDiameterInMm;
    private final double velocityInMetersPerSecond;

    protected DarcyWeisbachEquation(double frictionFactor, double internalDiameterInMm, double velocityInMetersPerSecond) {
        this.frictionFactor = frictionFactor;
        this.internalDiameterInMm = internalDiameterInMm;
        this.velocityInMetersPerSecond = velocityInMetersPerSecond;
    }

    protected double getFrictionLossesPerMeter() {
        double internalDiameterInMeters = internalDiameterInMm / 1000;
        return (frictionFactor / internalDiameterInMeters) * velocityInMetersPerSecond * velocityInMetersPerSecond / (2 * CalculatorConstants.GRAVITY_CONSTANT);
    }
}
