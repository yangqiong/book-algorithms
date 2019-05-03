import java.util.NoSuchElementException;

/**
 * 3.1.5 二分查找（基于有序数组）
 * 编译： javac -Xlint:unchecked -cp :../stdlib.jar:../01_chapter BinarySearchST.java
 * 运行： java -cp :../stdlib.jar:../01_chapter BinarySearchST.java < tinyST.txt
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

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            return vals[i];
        } else {
            return null;
        }
    }

    // 核心算法（递归）rank: 小于key的数量
    public int rank(Key key){
        return rank(key, 0, N - 1);
    }

    public int rank(Key key, int lo, int hi){
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0){
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    // 核心算法(迭代)
    // public int rank(Key key){
    //     int lo = 0, hi = N - 1;
    //     while(lo <= hi){
    //         int mid = lo + (hi - lo) / 2;
    //         int cmp = key.compareTo(keys[mid]);
    //         if (cmp < 0) hi = mid - 1;
    //         else if (cmp > 0) lo = mid + 1;
    //         else return mid;
    //     }
    //     return lo;
    // }

    public void put(Key key, Value val){
        int i = rank(key);
        if (i < N  && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0];
    }

    public Key max(){
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[N-1];
    }

    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null"); 
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null"); 

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++){
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    public static void main(String[] args) { 
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(100);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}