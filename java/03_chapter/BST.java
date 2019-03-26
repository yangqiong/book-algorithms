/**
 * 基于二叉查找树的符号表
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node node;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        public Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }

        public int size(){
            return size(root);
        }

        public int size(Node x){
            if ( x == null) return 0;
            else return x.N;
        }

        public Value get(Key key){
            return get(root, key);
        }

        public Value get(Node x, Key key){
            if (x == null) {
                return null;
            }
            int cmp = key.compareTo(x.key){
                if (cmp < 0) {
                    return get(x.left, key);
                } else if (cmp > 0){
                    return get(x.right, key);
                } else {
                    return x.val;
                }
            }
        }

        public void put(Key key, Value val){
            root = put(root, key, val);
        }

        public Node put(Node x, Key key, Value val){
            if (x == null) return new Node(key, val, 1);
            int cmp = key.compareTo(x.key)
            if (cmp < 0){
                x.left = put(x.left, key, val);
            } else if (cmp > 0){
                x.right = put(x.right, key, val);
            } else {
                x.val = val;
            }
            x.N = size(x.left) + size(x.right) + 1;
        }
    }
}