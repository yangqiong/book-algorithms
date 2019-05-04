/** 
 * 4.1.7.3 符号图
 * 编译：javac -cp :../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ SymbolGraph.java
 * 运行：java -cp :../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ SymbolGraph.java routes.txt " "
 * JFK
 *  MCO
 *  ATL
 *  ORD
 * LAX
 *  PHX
 *  LAS
 */

public class SymbolGraph {
    private BST<String, Integer> st;     // 符号名 -> 索引
    private String[] keys;              // 索引 -> 符号名
    private Graph G;

    public SymbolGraph(String stream, String sp){
        st = new BST<String, Integer>();
        In in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++){
                if (!st.contains(a[i])){
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name: st.keys()){
            keys[st.get(name)] = name;
            G = new Graph(st.size());
        }

        in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++){
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s)   { return st.contains(s); }
    public int index(String s)          { return st.get(s); }
    public String name(int v)           { return keys[v]; }
    public Graph graph()                { return G; }

    public static void main(String[] args){
        String filename = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        while(StdIn.hasNextLine()){
            String source = StdIn.readLine();
            if (sg.contains(source)){
                int s = sg.index(source);
                for (int v: graph.adj(s)){
                    StdOut.println(" " + sg.name(v));
                }
            } else {
                StdOut.println("input not contain '" + source + "'");
            }
        }
    }
}