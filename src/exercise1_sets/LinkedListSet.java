package exercise1_sets;

public class LinkedListSet {
    private MyLinkedList set;

    public LinkedListSet(){
        set = new MyLinkedList();
    }

    public boolean add(String value){
        if(set.contains(value)){
            return false;
        }
        set.add(value);
        return true;
    }

    public boolean contains(String value){
        return set.contains(value);
    }

    public int size(){
        return set.size();
    }

    public String toString(){
        return set.toString();
    }

}

class MyLinkedList{
    private ListNode head;
    private int size;
    private ListNode tail;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(String value){
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            ListNode newNode = new ListNode(value);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public boolean contains(String value){
        ListNode current = head;
        while(current != null){
            if(current.getValue().equals(value)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String toString(){
        ListNode current = head;
        String result = "[";
        while(current != null){
            result += current.getValue();
            if(current.getNext() != null){
                result += ", ";
            }
            current = current.getNext();
        }
        result += "]";
        return result;
    }
}

class ListNode{
    private String value;
    private ListNode next;

    public ListNode(String value) {
        this(value, null);
    }

    public ListNode(String value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}