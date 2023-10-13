package consistency.is.the.to.success.ds.map;

import java.util.Objects;

public class CustomMap<K extends Comparable<K>, V> {

    private final int capcity;
    private final Entry<K, V>[] table;

    public CustomMap(int capcity) {
        this.capcity = capcity;
        table = new Entry[capcity];
    }

    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketPosition = getHashCode(key);
        Entry<K, V> current = table[bucketPosition];
        if (current == null) {
            table[bucketPosition] = newEntry;
        } else {
            Entry<K, V> previous = null;
            while (current != null) { //we have reached last entry of bucket.
                if (current.key.compareTo(key) == 0) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[bucketPosition] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }


    private int getHashCode(K key) {
        return key.hashCode() % capcity;
    }

    public V get(K key) {
        int bucketPosition = getHashCode(key);
        Entry<K, V> current = table[bucketPosition];
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void pintAll() {
        Objects.requireNonNull(table);
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                System.out.print(entry);
                entry = entry.next;
            }
            System.out.println();
        }
    }

    static class Entry<K extends Comparable<K>, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return " [" + key + " ," + value + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry<?, ?> entry)) return false;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}

class TestingMap {
    public static void main(String[] args) {
        CustomMap<Integer, Integer> chm = new CustomMap<>(3);
        chm.put(1, 1);
        chm.put(2, 2);
        chm.put(3, 3);
        chm.put(4, 4);
        chm.put(5, 5);
        chm.put(6, 6);
        chm.put(7, 7);
        chm.put(1, 8);
        chm.put(9, 9);
        chm.put(10, 1);
        chm.put(4, 1);
        chm.put(5, 1);
        chm.put(19, 1);
        chm.pintAll();
    }
}
