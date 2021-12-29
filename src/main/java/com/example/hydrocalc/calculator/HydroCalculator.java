package com.example.hydrocalc.calculator;


import com.example.hydrocalc.model.entities.CalculatorPipeResults;


public class HydroCalculator {

    public static CalculatorPipeResults calculatePipe(double internalDiameter, double flow, double roughnessHeightInMm, double pipeLength, double kinematicViscosity) {

        double pipeCrossSectionInSquareMeters = new PipeCrossSectionAreaInSquareMeters(internalDiameter).getCrossSectionArea();
        double velocityInMeterPerSecond = new VelocityInMetersPerSecond(flow,pipeCrossSectionInSquareMeters).getVelocity();
        CalculatorPipeResults calculatorPipeResults = new CalculatorPipeResults();
        kinematicViscosity = setKinematicViscosityByDefaultIfZero(kinematicViscosity);
        double rNumber = new ReinoldsNumber(kinematicViscosity,velocityInMeterPerSecond,internalDiameter).getReinoldsNumber();
        double frictionFactor = new SwamiJaneEquation(roughnessHeightInMm, internalDiameter, rNumber).getFrictionLossesInMeterPerMeter();
        double lossesPerMeter = new DarcyWeisbachEquation(frictionFactor,internalDiameter,velocityInMeterPerSecond).getFrictionLossesPerMeter();
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

    private static double setKinematicViscosityByDefaultIfZero(double kinematicViscosity) {
        if (kinematicViscosity <= 0) {
            kinematicViscosity = CalculatorConstants.DEFAULT_KINEMATIC_VISCOSITY;
        }
        return kinematicViscosity;
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
