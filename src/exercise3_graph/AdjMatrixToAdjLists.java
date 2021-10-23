package exercise3_graph;

import java.util.ArrayList;

public class AdjMatrixToAdjLists {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0},
                          {1, 0, 1, 1,},
                          {1, 1, 0, 0},
                          {0, 1, 0, 0}};
        ArrayList<Integer>[] adjList = convert(matrix);
        System.out.println("Adjacency List is: ");
        print(adjList);
    }

    public static ArrayList<Integer>[] convert(int [][] matrix){
        int l = matrix[0].length;
        ArrayList<Integer>[] adjList = new ArrayList[l];
        for(int i = 0 ; i < l; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < l ; i++){
            for (int j = 0; j < l ; j++){
                if (matrix[i][j] == 1){
                    adjList[i].add(j);
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