package com.example.hydrocalc.calculator;

public class PipeCrossSectionAreaInSquareMeters {
    private final double internalDiameter;

    protected PipeCrossSectionAreaInSquareMeters(double internalDiameter) {
        this.internalDiameter = internalDiameter;
    }

    protected double getCrossSectionArea() {
        double internalDiameterInMeters = internalDiameter / 1000;
        return Math.PI * Math.pow(internalDiameterInMeters, 2) / 4;
    }
}
