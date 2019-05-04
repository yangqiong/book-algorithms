/**
 * 1.5.2.6 加权union-find算法
 * 编译：javac -cp :../stdlib.jar WeightedQuickUnionUF.java
 * 运行：java -cp :../stdlib.jar WeightedQuickUnionUF.java < tinyUF.txt
 * 结果：
 * 4 3
 * 3 8
 * 6 5
 * 9 4
 * 2 1
 * 5 0
 * 7 2
 * 6 1
 * 2 components
 */

public class WeightedQuickUnionUF{
    private int[] id;   
    private int[] sz;   // 各个根节点所对应的分量的大小
    private int count;

    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while( p != id[p] ) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] > sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}