package fileio;

import pojo.Child;
import pojo.Gift;

import java.util.ArrayList;

public class AnnualChange {
    private Double newSantaBudget;
    private ArrayList<Child> newChildren = new ArrayList<>();
    private ArrayList<Child> childrenUpdates = new ArrayList<>();
    private ArrayList<Gift> newGifts = new ArrayList<>();

    public AnnualChange(Double newSantaBudget, ArrayList<Child> newChildren,
                        ArrayList<Child> childrenUpdates, ArrayList<Gift> newGifts) {
        this.newSantaBudget = newSantaBudget;
        this.newChildren.addAll(newChildren);
        this.childrenUpdates.addAll(childrenUpdates);
        this.newGifts.addAll(newGifts);
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public ArrayList<Child> getChildrenUpdates() {
        return childrenUpdates;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }
}
