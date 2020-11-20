package homework18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MyEntry<String, Integer>> entryList = new ArrayList<>();

        entryList.add(new MyEntry<>("first", 1));
        entryList.add(new MyEntry<>("second", 2));
        entryList.add(new MyEntry<>("third", 3));
        entryList.add(new MyEntry<>("fourth", 4));
        Map<String, Integer> map = new Map<>(entryList);
        map.showKeys();
        map.showValues();
        map.addObj("fifth", 5);
        map.showMap();
        map.deleteObjByKey("first");
        map.deleteObjByValue(4);
        map.showMap();
    }
}
