package PressureFlow;

public class Velocity extends PipeLineDimensions {
    private double velocity;
    private double flow;

    public Velocity(double innerDiameter, double length, double flow) {
        super(innerDiameter, length);
        this.flow = flow / 1000;
        this.velocity = this.flow / super.getCrossSectionArea();
    }

    public double getVelocity() {
        return velocity;
    }

    public double getFlow() {
        return flow;
    }

    private double setFlow(double flow) {
        return this.flow / 1000;
    }

}
