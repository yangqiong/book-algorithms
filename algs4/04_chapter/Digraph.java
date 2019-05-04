/** 
 * 4.2.2 有向图
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ Digraph.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ Digraph.java tinyDG.txt
 * 结果：
 * 13 vertices, 22 edges 
 * 0: 5 1 
 * 1: 
 * 2: 0 3 
 * 3: 5 2 
 * 4: 3 2 
 * 5: 4 
 * 6: 9 4 8 0 
 * 7: 6 9 
 * 8: 6 
 * 9: 11 10 
 * 10: 12 
 * 11: 4 12 
 * 12: 9
 */

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Digraph(In in){
        this.V = in.readInt();
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
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
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++){
            for (int w: adj[v]){
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++){
            s.append(String.format("%d: ", v));
            for (int w: adj[v]){
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}