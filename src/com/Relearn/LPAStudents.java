package com.Relearn;

public class LPAStudents extends Student{
    private double percentComplete;

    public LPAStudents() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
//        return super.toString();
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
