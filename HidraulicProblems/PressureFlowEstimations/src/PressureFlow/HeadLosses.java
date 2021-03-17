package PressureFlow;

public class HeadLosses extends ColbrukWhiteEquation {
    private double headLosses;
    private final double g = 9.81;


    public HeadLosses(double innerDiameter, double length, double flow, double roughness) {
        super(innerDiameter, length, flow, roughness);
        this.headLosses = this.setHeadLosses();
    }

    private double setHeadLosses() {
        double lambda = super.getLambda();
        double pipeLength = super.getLength();
        double velocity = super.getVelocity();
        double diameter = super.getInnerDiameter();
        return lambda * pipeLength * Math.pow(velocity, 2) / (2 * g * diameter);
    }

    public double getHeadLosses() {
        return headLosses;
    }
    public double estimateHeadLossesPerMeter () {
        return this.getHeadLosses() / super.getLength();
    }
}
