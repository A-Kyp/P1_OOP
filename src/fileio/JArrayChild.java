package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import pojo.Child;

import java.util.ArrayList;
import java.util.LinkedList;

public class JArrayChild {
    @JsonProperty
    LinkedList<Child> children = new LinkedList<>();

    public void load(ArrayList<Child> kids) {
        children.addAll(kids);
    }
}
