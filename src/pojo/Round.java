package pojo;

import common.Constants;
import service.ChildService;
import service.RoundService;

import java.util.ArrayList;

public class Round {
    private Double budgetUnit = 0d;
    RoundService roundService = RoundService.getInstance();
    ChildService childService = ChildService.getInstance();

    public Double getBudgetUnit() {
        return budgetUnit;
    }

    //calculate average niceScore
    public void calcAverageScore(ArrayList<Child> kids) {
        for (Child c : kids) {
            childService.updateAvgScore(c);
        }
    }

    //distribute santaBudget
    public void calcBudgetUnit(Double santaBudget, ArrayList<Child> kids) {
        budgetUnit = santaBudget / roundService.sumAvg(kids);
    }

    //calculate assigned budget for each kid
    public void calcAllocatedBudget(ArrayList<Child> kids) {
        for(Child c : kids) {
            childService.updateAllocatedBudget(c, budgetUnit);
        }
    }

    //distribute gifts
    public void distributeGifts(ArrayList<Child> kids, ArrayList<Gift> gifts) {
        for (Child c : kids) {
            childService.allocateGift(c, gifts);
        }
    }

    //annual change -> add new kids to the list of children
    public void addNewChildren(ArrayList<Child> initial, ArrayList<Child> newKids) {
        if(newKids != null) {
            childService.updateMassHistory(newKids);
            initial.addAll(newKids);
        }
    }

    //annual change -> update existing kids info
    public void roundHistoryUpdate(ArrayList<Child> initial, ArrayList<Child> updates) {
        for(Child update : updates) {
            for(Child c : initial) {
                if(c.getId() == update.getId()) {
                    if(update.getAverageScore() != null) {
                        c.getNiceScoreHistory().add(update.getAverageScore());
                    }
                    if(update.getGiftsPreferences() != null) {
                        childService.updatePreferences(c, update.getGiftsPreferences());
                    }
                }
            }
        }
    }

    //annual change -> update gift list
    public void addNewGifts(ArrayList<Gift> initial, ArrayList<Gift> newGift) {
        if(newGift != null) {
            initial.addAll(newGift);
        }

    }

    //annual change -> everybody ages!! A year has passed!
    public void aYearHasPassed(ArrayList<Child> kids) {
        for(Child c : kids) {
            childService.updateAge(c);
        }
    }

    //annual change -> eliminate young adults
    public void eliminateYoungAdults(ArrayList<Child> kids) {
        kids.removeIf(c -> c.getAge() > Constants.TEEN_AGE);
    }

    //annual change -> reset receivedGifts
    public void resetReceivedGifts(ArrayList<Child> kids) {
        for(Child c : kids) {
            childService.resetReceivedGifts(c);
        }
    }
}
