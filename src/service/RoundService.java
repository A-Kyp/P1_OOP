package service;

import pojo.Child;

import java.util.ArrayList;

public class RoundService {
    private static RoundService INSTANCE;

    private RoundService() {}

    public static RoundService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RoundService();
        }
        return INSTANCE;
    }

    public Double sumAvg(ArrayList<Child> kids) {
        double sum = 0d;
        for(Child c : kids) {
            sum += c.getAverageScore();
        }
        return sum;
    }
}
