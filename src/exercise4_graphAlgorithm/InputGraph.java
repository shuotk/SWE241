package exercise4_graphAlgorithm;

public class InputGraph {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge('A','B');
        g.addEdge('A','D');
        g.addEdge('A','I');
        g.addEdge('B','C');
        g.addEdge('B','D');
        g.addEdge('B','E');
        g.addEdge('C','E');
        g.addEdge('C','F');
        g.addEdge('D','E');
        g.addEdge('D','G');
        g.addEdge('E','F');
        g.addEdge('E','G');;
        g.addEdge('E','H');
        g.addEdge('F','H');
        g.addEdge('G','H');
        g.addEdge('G','I');
        g.addEdge('H','J');
        g.addEdge('I','J');
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(g, 'A');
        System.out.println(depthFirstPaths.pathTo('I'));
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(g, 'A');
        System.out.println(breadthFirstPaths.pathTo('H'));
    }
}
