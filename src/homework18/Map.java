package homework18;

import java.util.*;

public class Map<K, V> {

    private List<MyEntry<K, V>> myEntries;

    public Map(List<MyEntry<K, V>> myEntries) {
        this.myEntries = myEntries;
    }

    public List<MyEntry<K, V>> getMyEntries() {
        return myEntries;
    }

    public boolean addObj(K key, V value) {
        Iterator<MyEntry<K, V>> iterator = myEntries.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(key)) {
                System.out.println("Can`t add this key. He is already in this map");
                return false;
            }
        }
        MyEntry<K, V> entry = new MyEntry<>(key, value);
        myEntries.add(entry);
        return true;
    }

    public boolean deleteObjByKey(K key) {
        Iterator<MyEntry<K, V>> iterator = myEntries.iterator();
        while (iterator.hasNext()) {
            MyEntry<K, V> next = iterator.next();
            if (next.getKey().equals(key)) {
                System.out.println("Delete entry with key '" + key + "'");
                myEntries.remove(next);
                return true;
            }
        }
        return false;
    }

    public boolean deleteObjByValue(V value) {
        Iterator<MyEntry<K, V>> iterator = myEntries.iterator();
        while (iterator.hasNext()) {
            MyEntry<K, V> next = iterator.next();
            if (next.getValue().equals(value)) {
                System.out.println("Delete entries with value " + value);
                myEntries.remove(next);
                return true;
            }
        }
        return false;
    }

    public void showKeys() {
        System.out.print("Keys: ");
        Iterator<MyEntry<K, V>> iterator = myEntries.iterator();
        Set<K> keys = new LinkedHashSet<>();
        while (iterator.hasNext()) {
            keys.add(iterator.next().getKey());
        }
        keys.forEach(x -> System.out.print(x + "\t"));
        System.out.println();
    }

    public void showValues() {
        System.out.print("Values: ");
        Iterator<MyEntry<K, V>> iterator = myEntries.iterator();
        List<V> values = new ArrayList<>();
        while (iterator.hasNext()) {
            values.add(iterator.next().getValue());
        }
        values.forEach(x -> System.out.print(x + "\t"));
        System.out.println();
    }

    public void showMap() {
        System.out.println("Map");
        for (MyEntry<K, V> myEntry : myEntries) {
            System.out.println("Key: " + myEntry.getKey() + "\t -> Value: " + myEntry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "myEntries=" + myEntries +
                '}';
    }
}
