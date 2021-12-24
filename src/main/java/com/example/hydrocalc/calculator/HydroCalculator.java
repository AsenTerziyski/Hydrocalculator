package com.example.hydrocalc.calculator;


import com.example.hydrocalc.model.entities.CalculatorPipeResults;


public class HydroCalculator {

    public static CalculatorPipeResults calculatePipe(double internalDiameter, double flow, double roughnessHeightInMm, double pipeLength, double kinematicViscosity) {

        double pipeCrossSectionInSquareMeters = new PipeCrossSectionAreaInSquareMeters(internalDiameter).getCrossSectionArea();
        double velocityInMeterPerSecond = new VelocityInMetersPerSecond(flow,pipeCrossSectionInSquareMeters).getVelocity();

        CalculatorPipeResults calculatorPipeResults = new CalculatorPipeResults();
        if (kinematicViscosity <= 0) {
            kinematicViscosity = CalculatorConstants.DEFAULT_KINEMATIC_VISCOSITY;
        }

        double rNumber = new ReinoldsNumber(kinematicViscosity,velocityInMeterPerSecond,internalDiameter).getReinoldsNumber();

        double roughnessHeightInMeters = roughnessHeightInMm / 1000;
        double internalDiameterInMeters = internalDiameter / 1000;
        double intermediateVariable = Math.log10(roughnessHeightInMeters / (3.7 * internalDiameterInMeters) + 5.74 / Math.pow(rNumber, 0.9));
        double frictionFactor = 0.25 / Math.pow(intermediateVariable, 2);
        double lossesPerMeter = (frictionFactor / internalDiameterInMeters) * velocityInMeterPerSecond * velocityInMeterPerSecond / (2 * CalculatorConstants.GRAVITY_CONSTANT);

        setVelocityWarnings(velocityInMeterPerSecond, calculatorPipeResults);

        return calculatorPipeResults
                .setFlowInLitersPerSecond(flow)
                .setPipeInternalDiameter(internalDiameter)
                .setPipeTotalLength(pipeLength)
                .setVelocityInMetersPerSecond(velocityInMeterPerSecond)
                .setRoughnessHeightInMm(roughnessHeightInMm)
                .setLossesPerMeter(lossesPerMeter)
                .setTotalLosses(lossesPerMeter * pipeLength);
    }

    private static void setVelocityWarnings(double velocityInMeterPerSecond, CalculatorPipeResults calculatorPipeResults) {
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
    }

}
