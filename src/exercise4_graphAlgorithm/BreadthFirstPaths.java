package exercise4_graphAlgorithm;

import java.util.*;

public class BreadthFirstPaths {
    private boolean[] marked;
    private char[] edgeTo;
    private char s;

    public BreadthFirstPaths(Graph G, char s){
        marked = new boolean[G.getV()];
        edgeTo = new char[G.getV()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, char s){
        Queue<Character> fringe = new PriorityQueue<>();
        fringe.add(s);
        marked[s - 'A'] = true;
        while (!fringe.isEmpty()){
            char v = fringe.poll();
            for (char w: G.adj(v)){
                if (!marked[w - 'A']){
                    fringe.add(w);
                    System.out.println(w);
                    marked[w - 'A'] = true;
                    edgeTo[w - 'A'] = v;
                }
            }
        }
    }

    public List<Character> pathTo(char v){
        if(!hasPathTo(v)) return null;
        List<Character> path = new ArrayList<>();
        for (char x = v; x != s; x = edgeTo[x - 'A']){
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public boolean hasPathTo(char v){
        return marked[v - 'A'];
    }

//    public static void main(String[] args) {
//        Graph g = new Graph(5);
//        g.addEdge('A','B');
//        g.addEdge('B','D');
//        g.addEdge('C','A');
//        g.addEdge('B','E');
//        g.addEdge('D','E');
//        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(g, 'A');
//        System.out.println(breadthFirstPaths.pathTo('E'));
//
//    }
//
}
