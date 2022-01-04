package sort;

import pojo.Gift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    public static void sortGift(ArrayList<Gift> gifts) {
        Collections.sort(gifts, new Comparator<Gift>() {
            @Override
            public int compare(Gift o1, Gift o2) {
                if(o1.getCategory().compareTo(o2.getCategory()) == 0) {
                    return o1.getPrice().compareTo(o2.getPrice());
                }
                return o1.getCategory().compareTo(o2.getCategory());
            }
        });
    }
}
