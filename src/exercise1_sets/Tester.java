package exercise1_sets;

import exercise1_sets.BinaryTreeSet;
import exercise1_sets.HashTableSet;
import exercise1_sets.LinkedListSet;



public class Tester {
    public static void main(String[] args) {
        LinkedListSet linkedListSet = new LinkedListSet();
        linkedListSet.add("hello");
        linkedListSet.add("123");
        linkedListSet.add("hello");
        System.out.println(linkedListSet);

        BinaryTreeSet binaryTreeSet = new BinaryTreeSet();
        binaryTreeSet.add("genki");
        binaryTreeSet.add("100");
        System.out.println(binaryTreeSet.contains("100"));
        System.out.println(binaryTreeSet.size());
        System.out.println(binaryTreeSet);

        HashTableSet hashTableSet = new HashTableSet();
        hashTableSet.add("ok");
        System.out.println(hashTableSet);

    }
}
