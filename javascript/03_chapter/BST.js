/**
 * 基于二叉查找树的符号表
 */

class Node {
    constructor(key, val, N){
        this.key = key;
        this.val = val;
        this.N = N;
    }
}

class BST {
    constructor(){
        this.root = null;
        this.left = null;
        this.right = null;
    }

    size(node){
        if (node){
            return node.N;
        } else {
            return 0;
        }
    }

    get(key){
        this._get(this.root, key)
    }

    _get(node, key){
        if (node === null){
            return null;
        }
        if (node.key < key){
            return this._get(node.right, key)
        } else if (node.key > key){
            return this._get(node.left, key);
        } else {
            return node.val;
        }
    }

    put(key, val){
       this.root = this._put(this.root, key, val);
    }

    _put(node, key, val){
        if (!node){
            return new Node(key, val, 1);
        }
        if (node.key < key){
            node.right = this._put(node.right, key, val)
        } else if (node.key > key){
            node.left = this._put(node.left, key, val)
        } else {
            node.val = val;
        }
        node.N = this.size(node.left) + this.size(node.right) + 1;
        return node;
    }

    print(){
        this._print(this.root);
    }

    _print(node){
        if (node){
            this._print(node.left);
            console.log(node.key);
            this._print(node.right);
        }
    }
}

let st = new BST();
st.put('L', 11);
st.put('P', 10);
st.put('M', 9);
st.put('X', 7);
st.put('H', 5);
st.put('C', 4);
st.put('R', 3);
st.put('A', 8);
st.put('E', 12);
st.put('S', 0);

st.print();


// console.log(st.root.val, st.root.left.val, st.root.right.val);
// console.log(st.get('A'))
// console.log(st.get('C'))
// console.log(st.get('M'))
// console.log(st.get('S'))
// console.log(st.get('X'))