package exercise4_graphAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private List<Character>[] adj;

    public int getV() {
        return V;
    }

    public Graph(int V){
        this.V = V;
        adj = (List<Character>[]) new ArrayList[V];
        for (int v = 0; v < V; v++){
            adj[v] = new ArrayList<Character>();
        }
    }

    public void addEdge(char v, char w){
        adj[v - 'A'].add(w);
        adj[w - 'A'].add(v);
    }

    public Iterable<Character> adj(char v){
        return adj[v - 'A'];
    }

    public static void print (Graph G){
        for (int v = 0; v < G.V; v++){
            for (int w: G.adj((char)(v + 'A'))){
                System.out.println(v + "-" + w);
            }
        }
    }
}
