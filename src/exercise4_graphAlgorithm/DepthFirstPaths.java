package exercise4_graphAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepthFirstPaths {
    private boolean[] marked;
    private char[] edgeTo;
    private char s;

    public DepthFirstPaths(Graph G, char s){
        marked = new boolean[G.getV()];
        edgeTo = new char[G.getV()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        v -= 'A';
        marked[v] = true;
        for (int w: G.adj((char)(v + 'A'))){
            if(!marked[w - 'A']){ //isMarked(1)?No
                edgeTo[w - 'A'] = (char)(v + 'A'); //edgeTo[1] = 0
                dfs(G,w); //dfs(1)
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
//        Graph g = new Graph(4);
//        g.addEdge('A','B');
//        g.addEdge('B','D');
//        g.addEdge('C','D');
//        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(g, 'A');
//        System.out.println(depthFirstPaths.pathTo('C'));
//
//    }
}
