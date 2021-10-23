package exercise2_sort;

import java.util.ArrayList;

public class InsertionSort {
    public static void sort(ArrayList<String> list){
        for(int i = 1; i < list.size() ; i++){
            for (int j = i - 1; j >= 0; j--){
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }
}

