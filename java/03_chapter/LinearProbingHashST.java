/**
 * 基于线性探测的符号表
 */

public class LinearProbingHashST<Key, Value> {
    private int N;          // 符号表中键值对的总数
    private int M = 16;     // 线性探测表的大小
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(){
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void resize();
    public void put(Key key, Value val){
        if (N >= M /2){
            resize(2 * M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1)% M){
            if (keys[i].equals(key)) {
                vals[i] = val;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i+1)%M){
            if (keys[i].equals(key)){
                return vals[i]
            }
        } 
        return null;
    }
}