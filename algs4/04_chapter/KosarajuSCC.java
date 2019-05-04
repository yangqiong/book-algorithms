/** 
 * 4.2.5.3 计算强连通分量的Kosaraju算法（理解有点困难）
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ KosarajuSCC.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ KosarajuSCC.java tinyDG.txt
 */

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());   // 1. G的反向图
        for (int s : order.reversePost()){                          // 2. 逆后序
            if (!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean strongConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        KosarajuSCC scc = new KosarajuSCC(G);

        int m = scc.count();
        StdOut.println(m + " strong components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++){
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++){
            components[scc.id(v)].enqueue(v);
        }

        for (int i = 0; i < m; i++){
            for (int v : components[i]){
                StdOut.print(v  + " ");
            }
            StdOut.println();
        }
    }
}