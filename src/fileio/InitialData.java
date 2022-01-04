package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Cities;
import pojo.Child;
import pojo.Gift;

import java.util.ArrayList;

public class InitialData {
    private Double santaBudget;
    @JsonProperty
    private ArrayList<Child> children = new ArrayList<>();
    private ArrayList<Gift> gifts = new ArrayList<>();
    private ArrayList<Cities> cities = new ArrayList<>();

    public InitialData() { }
    public InitialData(Double santaBudget, ArrayList<Child> children,
                       ArrayList<Gift> gifts, ArrayList<Cities> cities) {
        this.santaBudget = santaBudget;
        this.children.addAll(children);
        this.gifts.addAll(gifts);
        this.cities = cities;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "santaBudget=" + santaBudget +
                ", children=" + children +
                ", gifts=" + gifts +
                ", cities=" + cities +
                '}';
    }
}
