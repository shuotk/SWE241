package exercise1_sets;

public class HashTableSet {
    private static final double LOADING_FACTOR = 0.8;
    private ListNode[] bucket;
    private int capacity;
    private int size;

    public HashTableSet(){
        // consider that input file is large, use large capacity
        capacity = 1000;
        bucket = new ListNode[capacity];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(String value){
        if(((size + 1) * 1.0 / capacity) >= LOADING_FACTOR){
            int currentSize = size();
            refactor();
            size = currentSize;
        }
        if(!contains(value)){
            int index = Math.abs(value.hashCode() % capacity);
            ListNode newValue = new ListNode(value, bucket[index]);
            bucket[index] = newValue;
            size++;
            return true;
        }
        return false;
    }

    private void refactor(){
        ListNode[] oldBucket = bucket;
        capacity *= 2;
        bucket = new ListNode[capacity];
        for(ListNode each: oldBucket){
            ListNode current = each;
            while(current != null){
                add(current.getValue());
                current = current.getNext();
            }
        }
    }

    public boolean contains(String value){
        int hashCode = value.hashCode();
        int index = Math.abs(hashCode % capacity);
        ListNode current = bucket[index];
        while(current != null){
            if(current.getValue().equals(value)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public String toString(){
        String result = "";
        for(ListNode each: bucket){
            ListNode current = each;
            while(current != null){
                result = result + ", " + current.getValue();
                current = current.getNext();
            }
        }
        if(result.equals("")) return "[]";
        result = "[" + result.substring(2) + "]";
        return result;
    }
}
