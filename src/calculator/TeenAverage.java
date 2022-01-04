package calculator;

import pojo.Child;

public class TeenAverage extends AverageScoreCalculator{
    private static TeenAverage INSTANCE = null;

    private TeenAverage() { }

    public static TeenAverage getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new TeenAverage();
        }
        return INSTANCE;
    }

    @Override
    public Double getAverage(Child kid) {
        double sum = 0d;
        int weight = kid.getNiceScoreHistory().size();
        int totalWeight = weight * (weight + 1) / 2;
        weight = 1;

        for (Double score : kid.getNiceScoreHistory()) {
            sum += score * weight;
            weight ++;
        }

        return sum / totalWeight;
    }
}
