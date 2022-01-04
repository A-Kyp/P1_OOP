package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import pojo.Child;

import java.util.ArrayList;

public class JArrayRounds {
    @JsonProperty
    private final ArrayList<JArrayChild> annualChildren = new ArrayList<>();

    public ArrayList<JArrayChild> getAnnualChildren() {
        return annualChildren;
    }
}
