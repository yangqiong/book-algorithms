/**
 * 红黑二叉查找树
 */
class Node {
    constructor(key, val, N, color){
        this.key = key;
        this.val = val;
        this.N = N;
        this.color = color;
        this.left = null;
        this.right = null;
    }
}

class RedBlackBST {
    constructor(){
        this.root = null;
    }
    
    isRed(node){
        if (node === null){
            return false;
        } else {
            return node.color === 'RED'
        }
    }

    size(h){
        if (h) {
            return h.N;
        } else {
            return 1;
        }
    }

    rotateLeft(h){
        let x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = 'RED';
        x.N = h.N;
        h.N = 1 + this.size(h.left) + this.size(h.right)
        return x;
    }

    rotateRight(h){
        let x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = 'RED';
        x.N = h.N;
        h.N = 1 + this.size(h.left) + this.size(h.right);
        return x;
    }

    flipColors(h){
        h.color = 'RED';
        h.left.color = 'BLACK';
        h.right.color = 'BLACK';
    }

    put(key, val){
        this.root = this._put(this.root, key, val);
        this.root.color = 'BLACK'
    }

    _put(node, key, val){
        if (node === null){
            return new Node(key, val, 1, 'RED');
        }
        if (key < node.key){
            node.left = this._put(node.left, key, val);
        } else if (key > node.key){
            node.right = this._put(node.right, key, val);
        } else {
            node.val = val;
        }
        /* =================== 三条规则 ========================= */
        if (this.isRed(node.right) && !this.isRed(node.left)){
            node = this.rotateLeft(node)
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)){
            node = this.rotateRight(node)
        }
        if (this.isRed(node.left) && this.isRed(node.right)){
            this.flipColors(node)
        }
        /* ==================================================== */
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node
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

let st = new RedBlackBST();
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