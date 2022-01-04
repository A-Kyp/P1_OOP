package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;
import pojo.Child;
import service.ChildService;

import java.util.ArrayList;
import java.util.LinkedList;

public class JArrayChild {
    @JsonProperty
    ArrayList<Child> children = new ArrayList<>();

    public void load(ArrayList<Child> kids) {
        ChildService childService = ChildService.getInstance();
        for (Child c : kids) {
            Child clone = new Child();
            childService.deepCopy(c, clone);
            children.add(clone);
        }
    }
}
