package exercise2_sort;

import java.util.ArrayList;

public class HeapSort {
    private static void swap(ArrayList<String> list, int index1, int index2) {
        String temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
    public static void sort(ArrayList<String> list) {
        int n = list.size();
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(list,0,i);
            heapify(list, i, 0);
        }
    }
    private static void heapify(ArrayList<String> list, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // If left child is larger than root
        if (l < n && list.get(l).compareTo(list.get(largest)) > 0)
            largest = l;
        // If right child is larger than largest so far
        if (r < n && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;
        // If largest is not root
        if (largest != i) {
            swap(list, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}

