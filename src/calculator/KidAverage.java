package calculator;

import pojo.Child;

public class KidAverage extends AverageScoreCalculator{
    private static KidAverage INSTANCE = null;

    private KidAverage() { }

    public static KidAverage getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new KidAverage();
        }
        return INSTANCE;
    }

    @Override
    public Double getAverage(Child kid) {
        Double sum = 0d;
        for(Double score : kid.getNiceScoreHistory()) {
            sum += score;
        }
        return sum/ kid.getNiceScoreHistory().size();
    }
}
