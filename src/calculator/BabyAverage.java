package calculator;

import common.Constants;
import pojo.Child;

public class BabyAverage extends AverageScoreCalculator{
    private static BabyAverage INSTANCE = null;

    private BabyAverage() { }

    public static BabyAverage getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new BabyAverage();
        }
        return INSTANCE;
    }

    @Override
    public Double getAverage(Child kid) {
        return Constants.BABY_SCORE;
    }
}
