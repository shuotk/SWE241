package exercise2_sort;
import java.util.ArrayList;

public class MergeSort {
    public static void sort(ArrayList<String> list){
        if (list.size() > 1){
            ArrayList<String> half1 = new ArrayList<>();
            ArrayList<String> half2 = new ArrayList<>();
            int size1 = list.size() / 2;
            int size2 = list.size() - size1;
            for (int i = 0; i < size1; i++){
                half1.add(list.remove(0));
            }
            for (int i = 0; i < size2; i++){
                half2.add(list.remove(0));
            }
            sort(half1);
            sort(half2);
            mergeInto(list, half1, half2);
        }
    }

    public static void mergeInto(ArrayList<String> result,
                                 ArrayList<String> list1,
                                 ArrayList<String> list2){
        while(!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.get(0).compareTo(list2.get(0)) <= 0) {
                result.add(list1.remove(0));
            } else {
                result.add(list2.remove(0));
            }
        }
        while(!list1.isEmpty()){
            result.add(list1.remove(0));
        }
        while(!list2.isEmpty()){
            result.add(list2.remove(0));
        }

    }
}
