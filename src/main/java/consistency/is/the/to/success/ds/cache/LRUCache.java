package consistency.is.the.to.success.ds.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K extends Comparable<K> ,V> {

    private final Map<K ,Entry<K,V>> cache;
    private final int capacity;
    private Entry<K,V> head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public void put(K key ,V value){
        Entry<K,V> newEntry = new Entry<>(key, value);
        if(cache.containsKey(key)){
           Entry<K,V> oldvalue=cache.get(key);
           delete(oldvalue);
           addAtHead(newEntry);
        }else {
            if(capacity> cache.size()){
                addAtHead(newEntry);
                cache.put(key,newEntry);
            }else{
                cache.remove(tail.key);
                delete(tail);
                addAtHead(newEntry);
                cache.put(key,newEntry);
            }
        }






    }


    static class Entry<K extends Comparable<K> ,V>{
        K key;
        V value;
        Entry<K,V> next ,prev;
        public Entry(K key ,V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return  " key: "+key +" value :"+value;
        }
    }

    public Entry<K ,V> getKey(K key){
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        else return null;

    }

    public void addAtHead(Entry<K ,V> node){
        if(head==null){
            head=tail=node;
        }else {
            Entry<K, V> curernt = head;
            node.next = curernt;
            curernt.prev = node;
            head = node;
        }
    }

    public void delete(Entry<K,V> node ){
        if(node.next==null){
            tail=node;
        }else if (node.prev==null){
            head=node;
        }else{
            Entry<K,V> nodePrev= node.prev;
            Entry<K,V> nodeNext=node.next;
            nodePrev.next=nodeNext;
            nodeNext.prev=nodePrev;
        }
    }
}
