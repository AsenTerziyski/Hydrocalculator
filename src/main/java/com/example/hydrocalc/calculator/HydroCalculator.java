package com.example.hydrocalc.calculator;


import com.example.hydrocalc.model.entities.CalculatorPipeResults;


public class HydroCalculator {

    public static CalculatorPipeResults calculatePipe(double internalDiameter, double flow, double roughnessHeightInMm, double pipeLength) {

        double flowInMeterCubicPerSecond = flow / 1000;
        double internalDiameterInMeters = internalDiameter / 1000;
        double pipeCrossSectionInSquareMeters = Math.pow(internalDiameterInMeters, 2) * Math.PI / 4;

        double velocityInMeterPerSecond = flowInMeterCubicPerSecond / pipeCrossSectionInSquareMeters;
        double kinematicViscosity = 0.000001306;
        double roughnessHeightInMeters = roughnessHeightInMm / 1000;
        double rNumber = internalDiameterInMeters * velocityInMeterPerSecond / kinematicViscosity;

        double intermediateVariable = Math.log10(roughnessHeightInMeters / (3.7 * internalDiameterInMeters) + 5.74 / Math.pow(rNumber, 0.9));
        double frictionFactor = 0.25 / Math.pow(intermediateVariable, 2);
        double lossesPerMeter = (frictionFactor / internalDiameterInMeters) * velocityInMeterPerSecond * velocityInMeterPerSecond / (2 * CalculatorConstants.GRAVITY_CONSTANT);

        CalculatorPipeResults calculatorPipeResults = new CalculatorPipeResults();

        if (velocityInMeterPerSecond >= CalculatorConstants.VELOCITY_HIGH) {
            calculatorPipeResults.setVelocityHigh(true);
        } else {
            calculatorPipeResults.setVelocityHigh(false);
        }

        if (velocityInMeterPerSecond <= CalculatorConstants.VELOCITY_LOW) {
            calculatorPipeResults.setVelocityLow(true);
        } else {
            calculatorPipeResults.setVelocityLow(false);
        }

        return calculatorPipeResults
                .setFlowInLitersPerSecond(flow)
                .setPipeInternalDiameter(internalDiameter)
                .setPipeTotalLength(pipeLength)
                .setVelocityInMetersPerSecond(velocityInMeterPerSecond)
                .setRoughnessHeightInMm(roughnessHeightInMm)
                .setLossesPerMeter(lossesPerMeter)
                .setTotalLosses(lossesPerMeter * pipeLength);
    }

}
