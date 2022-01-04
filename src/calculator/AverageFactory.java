package calculator;

import common.Constants;

public class AverageFactory {
    public static AverageScoreCalculator create(final Integer age) {
        if (age < Constants.BABY_AGE) {
            return BabyAverage.getINSTANCE();
        } else if (age < Constants.KID_AGE) {
            return KidAverage.getINSTANCE();
        } else
            return TeenAverage.getINSTANCE();
    }
}
