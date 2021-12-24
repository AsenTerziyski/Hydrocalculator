package com.example.hydrocalc.calculator;

public class PipeCrossSectionAreaInSquareMeters {
    private final double internalDiameter;

    public PipeCrossSectionAreaInSquareMeters(double internalDiameter) {
        this.internalDiameter = internalDiameter;
    }

    public double getCrossSectionArea() {
        double internalDiameterInMeters = internalDiameter / 1000;
        return Math.PI * Math.pow(internalDiameterInMeters, 2) / 4;
    }
}
