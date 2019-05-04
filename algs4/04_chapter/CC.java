/** 
 * 4.1.6 连通分量
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ CC.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ CC.java tinyG.txt 0
 */

public class CC {
    private boolean[] marked;
    private int[] id;           // 每个顶点所在的连同分量
    private int count;          

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++){
            if (!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)){
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int count(){
        return count;
    }

    public int id(int v){
        return id[v];
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        int m = cc.count();
        StdOut.println(m + " components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++){
            components[i] = new Queue<Integer>();
        }

        for (int v = 0; v < G.V(); v++){
            components[cc.id(v)].enqueue(v);
        }

        for (int i = 0; i < m; i++){
            for (int v: components[i]){
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}