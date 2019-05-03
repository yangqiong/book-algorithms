/**
 * Exercises 10
 * 编译： javac -cp :../../stdlib.jar:../../01_chapter:../. TestBST.java
 * 运行： java -cp :../../stdlib.jar:../../01_chapter:../. TestBST
 */

public class TestBST {
    public static void main(String[] args){
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split(" ");
        int n = keys.length;
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; i < n; i++){
            st.put(keys[i], i);
        }

        StdOut.println("size = " + st.size());
        StdOut.println("min = " + st.min());
        StdOut.println("max = " + st.max());
        StdOut.println();

        StdOut.println("Testing keys()");
        StdOut.println("--------------------------------");
        for (String s : st.keys()){
            StdOut.println(s + " " + st.get(s));
        }
        StdOut.println();

        StdOut.println("Testing select");
        StdOut.println("--------------------------------");
        for (int i = 0; i < st.size(); i++)
            StdOut.println(i + " " + st.select(i)); 
        StdOut.println();

        StdOut.println("key rank floor flor2 ceil");
        StdOut.println("-------------------------");
        for (char i = 'A'; i <= 'Z'; i++){
            String s = i + "";
            StdOut.printf("%2s %4d %4s %4s %4s\n", s, st.rank(s), st.floor(s), st.floor2(s), st.ceiling(s));
        }
        StdOut.println();
    }
}