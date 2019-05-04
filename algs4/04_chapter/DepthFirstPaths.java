/** 
 * 4.1.4 寻找路径
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ DepthFirstPaths.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ DepthFirstPaths.java tinyG.txt 0
 */


public class DepthFirstPaths {
    private boolean[] marked;   // 这个顶点是否调用过dfs()
    private int[] edgeTo;       // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;        // 起点
    
    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++){
            if (dfs.hasPathTo(v)){
                StdOut.printf("%d to %d: ", s, v);
                for (int x : dfs.pathTo(v)){
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }
        }
    }
}