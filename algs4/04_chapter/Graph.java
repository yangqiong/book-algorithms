/** 
 * 4.1.2.2 Graph数据类型（邻接表）
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ Graph.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ Graph.java tinyG.txt
 * 输入：A- B+ B+ B-
 * 输出：GPA = 3.25
 */

import java.util.Iterator;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(v + ": ");
            for (int w: adj[v]){
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}