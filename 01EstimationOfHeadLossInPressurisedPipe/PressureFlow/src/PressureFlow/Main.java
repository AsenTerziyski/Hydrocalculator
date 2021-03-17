package PressureFlow;

public class Main {
    public static void main(String[] args) {
//        PipeSize pipeSize = new PipeSize(1600.00);
//        System.out.println(pipeSize.getInnerDiameter());
//        System.out.println(pipeSize.getCrossSectionArea());
//
//        PipeLineDimensions pipeLineDimensions = new PipeLineDimensions(100, 15000);
//        System.out.println(pipeLineDimensions.getInnerDiameter());
//        System.out.println(pipeLineDimensions.getLength());
        Velocity velocityReinolds = new Velocity(100, 1000, 20);
        System.out.println(velocityReinolds.getVelocity());
        ReinoldsNumber reinoldsNumber = new ReinoldsNumber(100,1000,20);
        System.out.println(reinoldsNumber.getReinoldsNumber());


    }
}
