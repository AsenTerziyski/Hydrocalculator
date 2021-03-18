package PressureFlow;

public class ColbrukWhiteEquation extends ReinoldsNumber {
    private double lambda;
    private double systemRoughness;

    public ColbrukWhiteEquation(double innerDiameter, double length, double flow, double roughness) {
        super(innerDiameter, length, flow);
        this.setSystemRoughness(roughness);
        this.lambda = this.setLambda();
    }

    private double setLambda() {
        double currentLambda = 0.000000001;
        double Re = super.getReinoldsNumber();
        double k = this.systemRoughness;
        double d = super.getInnerDiameter();
        double equation = -2 * Math.log10((2.51 / (Re * Math.sqrt(currentLambda)) + k / (3.7 * d))) * Math.sqrt(currentLambda);
        while (true) {
            equation = -2 * Math.log10((2.51 / (Re * Math.sqrt(currentLambda)) + k / (3.7 * d))) * Math.sqrt(currentLambda);
            if (equation >= 1) {
                currentLambda += 0.000000001;
                if (equation == 1) {
                    return currentLambda;
                }

            } else {
                if(equation < 1) {
                    return currentLambda;
                }
                currentLambda-=0.000000001;
            }
        }
    }

    public double getLambda() {
        return this.lambda;
    }

    private void setSystemRoughness(double roughness) {
        this.systemRoughness = roughness / 1000;
    }

    public double getSystemRoughness() {
        return systemRoughness;
    }
}
