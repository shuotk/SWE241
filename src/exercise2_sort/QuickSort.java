package exercise2_sort;

import java.util.ArrayList;

public class QuickSort {
    private static void swap(ArrayList<String> list, int index1, int index2) {
        String temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
    private static int partition(ArrayList<String> list, int low, int high) {
        // pick a random spot for the pivot
        int spot = low + (int) ((high - low + 1) * Math.random());
        // put the pivot at the front
        swap(list, low, spot);
        // remember pivot
        String pivot = list.get(low);
        // loop invariant
        int index1 = low + 1;
        int index2 = high;
        while (index1 <= index2)
            if (list.get(index1).compareTo(pivot) <= 0) {
                index1++;
            } else if (list.get(index2).compareTo(pivot) > 0) {
                index2--;
            } else {
                swap(list, index1, index2);
                index1++;
                index2--;
            }
        swap(list, low, index2);
        return index2;

    }
    public static void sort(ArrayList<String> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sort(list, low, pivotIndex - 1);
            sort(list, pivotIndex + 1, high);
        }
    }

    public static void sort(ArrayList<String> list) {
        sort(list, 0, list.size() - 1);
    }


}