/**
 * 邻接表
 */

public class Graph{
    private final int V;            // 顶点数组
    private int E;                  // 边的数目
    private Bag<Interger>[] adj;    // 邻接表
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) = new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }
    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++){
            // 添加一条边
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

    public Interable<Interger> adj(int v){
        return adj[v];
    }
}