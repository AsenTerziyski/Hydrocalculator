package PressureFlow;

public class ReinoldsNumber extends Velocity {
    private final double ni = 0.000001306;
    private double reinoldsNumber;

    public ReinoldsNumber(double innerDiameter, double length, double flow) {
        super(innerDiameter, length, flow);
        this.reinoldsNumber = super.getVelocity() * super.getInnerDiameter() / ni;
    }

    public double getReinoldsNumber() {
        return reinoldsNumber;
    }
}
