package exercise2_sort;

import java.util.ArrayList;

public class SelectionSort {
    public static void sort(ArrayList<String> list){
        int minIndex;
        for(int i = 0; i < list.size() - 1 ; i++) {
            minIndex = i;
            for(int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
                String temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

}
