/** 
 * 4.2.5.4 可达性（待解决的研究问题）
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/ TransitiveClosure.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/ TransitiveClosure.java tinyDG.txt
 */

public class TransitiveClosure{
    private DirectedDFS[] all;

    TransitiveClosure(Digraph G){
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++){
            all[v] = new DirectedDFS(G, v);
        }
    }

    boolean reachable(int v, int w){
        return all[v].marked(w);
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        TransitiveClosure tc = new TransitiveClosure(G);

        StdOut.print("     ");
        for (int v = 0; v < G.V(); v++){
            StdOut.printf("%3d", v);
        }
        StdOut.println();
        StdOut.println("--------------------------------------------");

        for (int v = 0; v < G.V(); v++){
            StdOut.printf("%3d: ", v);
            for (int w = 0; w < G.V(); w++){
                if (tc.reachable(v, w)) StdOut.printf("  T");
                else StdOut.printf("   ");
            }
            StdOut.println();
        }
    }
}