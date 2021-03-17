package PressureFlow;

public class PipeLineDimensions extends PipeSize {
    private double length;

    public PipeLineDimensions(double innerDiameter, double length) {
        super(innerDiameter);
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
