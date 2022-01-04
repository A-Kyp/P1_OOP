package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import pojo.Child;

import java.util.ArrayList;

public class JArrayRounds {
    @JsonProperty
    private final ArrayList<ArrayList<Child>> annualChildren = new ArrayList<>();

    public ArrayList<ArrayList<Child>> getAnnualChildren() {
        return annualChildren;
    }
}
