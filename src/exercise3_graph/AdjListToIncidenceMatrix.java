package exercise3_graph;

import java.util.ArrayList;

public class AdjListToIncidenceMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0},
                {1, 0, 1, 1,},
                {1, 1, 0, 0},
                {0, 1, 0, 0}};
        ArrayList<Integer>[] adjList = AdjMatrixToAdjLists.convert(matrix);
        int[][] result = convert(adjList);
        print(result);
    }

    public static int[][] convert(ArrayList<Integer>[] adjList){
        Edges edges = new Edges();
        for (int i = 0; i < adjList.length; i++ ){
            ArrayList<Integer> list = adjList[i];
            for(int each : list){
                edges.add(new Edge(i, each));
            }
        }

        int edgeCount = edges.size();
        int[][] incMatrix = new int[adjList.length][edgeCount];
        int edgeNumber = 0;
        for(Edge each : edges.edges){
            incMatrix[each.x][edgeNumber] = 1;
            incMatrix[each.y][edgeNumber] = 1;
            edgeNumber++;
        }
        return incMatrix;
    }

    public static void print(int[][] incMatrix){
        for(int[] eachRow : incMatrix){
            for(int each : eachRow){
                System.out.print(each + " ");
            }
            System.out.println();
        }
    }

    static class Edge{
        int x;
        int y;
        Edge(int x, int y){
            this.x = x;
            this.y = y;
        }

        boolean equals(Edge other){
            return ((this.x == other.x) && (this.y == other.y))
                    || ((this.x == other.y) && (this.y == other.x));
        }

        public String toString(){
            return "[" + x + " " + y + "]";
        }
    }

    static class Edges{
        ArrayList<Edge> edges;
        Edges(){
            edges = new ArrayList<>();
        }

        int size(){
            return edges.size();
        }

        void add(Edge edge){
            if(!contains(edge)){
                edges.add(edge);
            }
        }

        boolean contains(Edge edge){
            for(Edge each : edges){
                if(each.equals(edge)){
                    return true;
                }
            }
            return false;
        }

        public String toString(){
            return edges.toString();
        }
    }

}
