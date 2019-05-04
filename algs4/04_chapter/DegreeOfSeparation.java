/** 
 * 4.1.7.4 间隔的度数
 * 编译：javac -cp :.:../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ DegreeOfSeparation.java
 * 运行：java -cp :.:../stdlib.jar:../.:../01_chapter/:../.:../03_chapter/ DegreeOfSeparation.java routes.txt " " "JFK"
 * 找不到符号BreadthFirstPaths？
 */

public class DegreeOfSeparation {
    public static void main(String[] args){
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.graph();
        String source = args[2];
        if (!sg.contains(source)){
            StdOut.println(source + " not in databases.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = BreadthFirstPaths(G, s);
        while(!StdIn.isEmpty()){
            String sink = StdIn.readLine();
            if (sg.contains(sink)){
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)){
                    for (int v: bfs.pathTo(t)){
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not connected");
                }
            } else {
                StdOut.println("Not in database.");
            }
        }
    }
}