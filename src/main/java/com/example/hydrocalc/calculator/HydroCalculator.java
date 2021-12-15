package com.example.hydrocalc.calculator;


import com.example.hydrocalc.model.CalculatorPipeResults;

public class HydroCalculator {

    public static CalculatorPipeResults calculatePipe(double internalDiameter, double flow, double roughnessHeightInMeters, double pipeLength) {

        double flowInMeterCubicPerSecond = flow / 1000;
        double internalDiameterInMeters = internalDiameter / 1000;
        double pipeCrossSectionInSquareMeters = Math.pow(internalDiameterInMeters, 2) * Math.PI / 4;
        double velocityInMeterPerSecond = flowInMeterCubicPerSecond / pipeCrossSectionInSquareMeters;
        double kinematicViscosity = 0.000001306;

        double rNumber = internalDiameterInMeters * velocityInMeterPerSecond / kinematicViscosity;
        double frictionFactor = 0.25 / Math.pow(Math.log10((roughnessHeightInMeters / (3.7 * internalDiameterInMeters) + 5.74 / Math.pow(rNumber, 0.9))), 2);
        double lossesPerMeter = frictionFactor * Math.pow(velocityInMeterPerSecond, 2) / (2 * 9.81 * internalDiameterInMeters);

        CalculatorPipeResults calculatorPipeResults = new CalculatorPipeResults();

        return calculatorPipeResults
                .setFlowInLitersPerSecond(flow)
                .setPipeInternalDiameter(internalDiameter)
                .setPipeTotalLength(pipeLength)
                .setVelocityInMetersPerSecond(velocityInMeterPerSecond)
                .setRoughnessHeightInMeters(roughnessHeightInMeters)
                .setLossesPerMeter(lossesPerMeter)
                .setTotalLosses(lossesPerMeter * pipeLength);

    }

}
