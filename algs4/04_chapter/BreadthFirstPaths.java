/** 
 * 4.1.5 广度优先搜索
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ BreadthFirstPaths.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ BreadthFirstPaths.java tinyG.txt 0
 */

public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;

    private boolean[] marked;   // 到达该顶点的最短路径已知吗
    private int[] edgeTo;       // 到达该顶点的已知路径上的最后一个顶点
    private int[] distTo;       // 最短路径的边数
    private final int s;        // 起点

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++){
            distTo[v] = INFINITY;
        }
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<Integer>();
        distTo[s] = 0;
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : G.adj(v)){
                if (!marked[w]){
                    edgeTo[w] = v;  // 保存最短路径的最后一条边
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public int distTo(int v){
        return distTo[v];
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
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++){
            if (bfs.hasPathTo(v)){
                StdOut.printf("%d to %d (%d): ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)){
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }
            
        }
    }
}