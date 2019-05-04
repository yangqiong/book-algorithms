/** 
 * 4.2.4 拓扑排序
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ Topological.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ Topological.java jobs.txt "/"
 */


public class Topological {
    private Iterable<Integer> order;    // 顶点的拓扑顺序
    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args){
        String filename = args[0];
        String separator = args[1];
        SysbolDigraph sg = new SysbolDigraph(filename, separator);
        Topological top = new Topological(sg.graph());
        for (int v : top.order()){
            StdOut.println(sg.name(v));
        }
    }
}