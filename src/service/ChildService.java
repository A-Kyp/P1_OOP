package service;

import calculator.AverageFactory;
import calculator.AverageScoreCalculator;
import enums.Category;
import pojo.Child;
import pojo.Gift;

import java.util.ArrayList;

public class ChildService {
    private static ChildService INSTANCE;

    private ChildService() {}

    public static ChildService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ChildService();
        }
        return INSTANCE;
    }

    public void updateHistory (Child c, Double score) {
        c.getNiceScoreHistory().add(score);
    }

    public void updateMassHistory (ArrayList<Child> kids) {
        for(Child c : kids) {
            this.updateHistory(c, c.getAverageScore());
        }
    }

    public void updateAvgScore (Child c) {
        AverageScoreCalculator calc;
        calc = AverageFactory.create(c.getAge());
        if (calc.getAverage(c) != null) {
            c.setAverageScore(calc.getAverage(c));
        } // else do nothing as the Child would be a young adult and is already eliminated
    }

    public void updateAllocatedBudget(Child c, Double budgetUnit) {
        c.setAssignedBudget(c.getAverageScore() * budgetUnit);
    }

    public void allocateGift(Child c, ArrayList<Gift> gifts) {
        double budget = c.getAssignedBudget();
        for (Category category : c.getGiftsPreferences()) {
            for (Gift g : gifts) {
                if (g.getCategory().compareTo(category) == 0 && g.getPrice() <= budget) {
                    c.getReceivedGifts().add(g);
                    budget -= g.getPrice();
                    break;
                }
            }
        }
    }

    public void updatePreferences(Child c, ArrayList<Category> newPref) {
        ArrayList<Category> combinedPref = new ArrayList<>();
        for(Category category : newPref) {
            if (!combinedPref.contains(category)) {
                combinedPref.add(category);
            }
        }

        for(Category category : c.getGiftsPreferences()) {
            if (!combinedPref.contains(category)) {
                combinedPref.add(category);
            }
        }

        c.setGiftsPreferences(combinedPref);
    }

    public void updateAge(Child c) {
        c.setAge(c.getAge() + 1);
    }

    public void resetReceivedGifts(Child c) {
        c.getReceivedGifts().clear();
    }

    public void deepCopy(Child src, Child dest) {
        dest.setId(src.getId());
        dest.setLastName(src.getLastName());
        dest.setFirstName(src.getFirstName());
        dest.setCity(src.getCity());
        dest.setAge(src.getAge());
        dest.setAverageScore(src.getAverageScore());
        dest.setAssignedBudget(src.getAssignedBudget());
        dest.getGiftsPreferences().addAll(src.getGiftsPreferences());
        dest.getNiceScoreHistory().addAll(src.getNiceScoreHistory());
        dest.getReceivedGifts().addAll(src.getReceivedGifts());
    }
}
