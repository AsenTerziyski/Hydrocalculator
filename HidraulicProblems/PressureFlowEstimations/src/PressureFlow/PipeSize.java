package PressureFlow;

public class PipeSize {
    private double innerDiameter;
    private double crossSectionArea;

    public PipeSize(double innerDiameter) {
        this.setInnerDiameter(innerDiameter);
        this.setCrossSectionArea();
    }

    private double setInnerDiameter (double innerDiameter) {
        return this.innerDiameter = innerDiameter / 1000;
    }

    public double getInnerDiameter() {
        return innerDiameter;
    }

    public double getCrossSectionArea() {
        return crossSectionArea;
    }

    private double setCrossSectionArea () {
        return this.crossSectionArea = Math.PI * getInnerDiameter() * getInnerDiameter() / 4.00;
    }
}
