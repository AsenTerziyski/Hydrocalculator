package PressureFlow;

public class Main {
    public static void main(String[] args) {
        HeadLosses headLosses = new HeadLosses(300, 1000, 70, 0.4);
        System.out.println(String.format("--> Pipe diameter = %.0f mm;", headLosses.getInnerDiameter()*1000));
        System.out.println(String.format("--> Pipe length = %.2fm;", headLosses.getLength()));
        System.out.println(String.format("--> System roughness = %.2f mm;", headLosses.getSystemRoughness()*1000));
        System.out.println(String.format("--> Flow = %.2f l/s;", headLosses.getFlow()*1000));
        System.out.println(String.format("--> Velocity = %.2f m/s;", headLosses.getVelocity()));
        System.out.println(String.format("--> Total head losses = %.2f m;", headLosses.getHeadLosses()));
        //System.out.println(headLosses.estimateHeadLossesPerMeter());
    }
}
