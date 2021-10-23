package exercise3_graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class IncidenceMatrixToAdjLists {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0},
                          {1, 0, 1, 1},
                          {0, 1, 1, 0},
                          {0, 0, 0, 1}};
        ArrayList<Integer>[] adjList = convert(matrix);
        System.out.println("Adjacency List is: ");
        print(adjList);
    }

    public static ArrayList<Integer>[] convert(int [][] matrix){
        ArrayList<Integer>[] adjList = new ArrayList[matrix.length];
        for(int i = 0 ; i < matrix.length; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < matrix[0].length; i++){
            int prev = -1;
            for (int j = 0; j < matrix.length; j++ ) {
                if (matrix[j][i] == 1 && prev == -1) {
                    prev = j;
                } else if (matrix[j][i] == 1 && prev != -1) {
                    adjList[prev].add(j);
                    adjList[j].add(prev);
                }
            }
        }
        return adjList;
    }
    public static void print(ArrayList<Integer>[] adjList){
        for (int i = 0; i < adjList.length; i++ ){
            System.out.print(i + ": [");
            for (int j = 0; j < adjList[i].size() - 1; j++ ){
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.print(adjList[i].get(adjList[i].size() - 1));
            System.out.println("]");
        }
    }
}
