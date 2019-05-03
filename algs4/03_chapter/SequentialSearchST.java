/**
 * 3.1.4 顺序查找（基于无序列表）
 * 编译： javac -cp :../stdlib.jar:../01_chapter SequentialSearchST.java
 * 运行： java -cp :../stdlib.jar:../01_chapter SequentialSearchST.java < tinyST.txt
 * 结果：
 * L 11
 * P 10
 * M 9
 * X 7
 * H 5
 * C 4
 * R 3
 * A 8
 * E 12
 * S 0
 */

public class SequentialSearchST<Key, Value>{
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next){
            queue.enqueue(x.key);
        }
        return queue;
    }

    public static void main(String[] args){
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()){
            StdOut.println(s + " " + st.get(s));
        }
    }
}