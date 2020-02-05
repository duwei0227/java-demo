package top.probiecoder.concurrent;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceHouse {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
//        List<SoftReference> houses = new ArrayList<>();

        int i = 0;
        while (true) {
            House buyer2 = new House();
//            SoftReference<House> buyer2 = new SoftReference<>(new House());
            houses.add(buyer2);
            System.out.println("i=" + (++i));
        }
    }
}

class House {
    private static final Integer DOOR_NUMBER = 200;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door {

    }
}
