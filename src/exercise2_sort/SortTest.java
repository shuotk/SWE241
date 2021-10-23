package exercise2_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SortTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("eee");
        list.add("ddd");
        list.add("ccc");
        //SelectionSort.sort(list);
        //InsertionSort.sort(list);
        //QuickSort.sort(list);
        //MergeSort.sort(list);
        HeapSort.sort(list);
        System.out.println(list);
    }
}
