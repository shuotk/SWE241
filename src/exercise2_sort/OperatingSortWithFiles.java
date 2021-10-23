package exercise2_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OperatingSortWithFiles {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("src/exercise2_sort/pride-and-prejudice.txt"));
        PrintWriter insertionSortResult = new PrintWriter("src/exercise2_sort/InsertionSortResult.txt");
        PrintWriter selectionSortResult = new PrintWriter("src/exercise2_sort/SelectionSortResult.txt");
        PrintWriter mergeSortResult = new PrintWriter("src/exercise2_sort/MergeSortResult.txt");
        PrintWriter quickSortResult = new PrintWriter("src/exercise2_sort/QuickSortResult.txt");
        PrintWriter heapSortResult = new PrintWriter("src/exercise2_sort/HeapSortResult.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            while (console.hasNextLine()) {
                String nextLine = removeSpChar(console.nextLine());
                String[] words = nextLine.split("\\s+");
                for (String each : words) {
                    if(!each.isEmpty()) {
                        data.add(each);
                    }
                }
            }
            ArrayList<String> selectionSort = new ArrayList<>(data);
            ArrayList<String> insertionSort = new ArrayList<>(data);
            ArrayList<String> mergeSort = new ArrayList<>(data);
            ArrayList<String> quickSort = new ArrayList<>(data);
            ArrayList<String> heapSort = new ArrayList<>(data);

//            long start1 = System.currentTimeMillis();
//            SelectionSort.sort(selectionSort);
//            double elapsed1 = (System.currentTimeMillis() - start1) / 1000.0;
//            System.out.println("our selectionSort time = " + elapsed1);
//            for(String each : selectionSort){
//                selectionSortResult.print(each + "\t");
//            }
//
//            long start2 = System.currentTimeMillis();
//            InsertionSort.sort(insertionSort);
//            double elapsed2 = (System.currentTimeMillis() - start2) / 1000.0;
//            System.out.println("our insertionSort time = " + elapsed2);
//            for(String each : insertionSort){
//                insertionSortResult.print(each + "\t");
//            }

            long start3 = System.currentTimeMillis();
            MergeSort.sort(mergeSort);
            double elapsed3 = (System.currentTimeMillis() - start3) / 1000.0;
            System.out.println("our mergeSort time = " + elapsed3);
            for(String each : mergeSort){
                mergeSortResult.print(each + "\t");
            }

            long start4 = System.currentTimeMillis();
            QuickSort.sort(quickSort);
            double elapsed4 = (System.currentTimeMillis() - start4) / 1000.0;
            System.out.println("our quickSort time = " + elapsed4);
            for(String each : quickSort){
                quickSortResult.print(each + "\t");
            }

            long start5 = System.currentTimeMillis();
            HeapSort.sort(heapSort);
            double elapsed5 = (System.currentTimeMillis() - start5) / 1000.0;
            System.out.println("our heapSort time = " + elapsed5);
            for(String each : heapSort){
                heapSortResult.print(each + "\t");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            console.close();
            heapSortResult.close();
        }

    }

    private static String removeSpChar(String input) {
        String result = input.replaceAll("[^\\w\\d ]", " ");
        return result;
    }
}
