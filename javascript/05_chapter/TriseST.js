/**
 * 单词查找树（又称前缀树，是一种哈希树的变种）
 * 优点：
 * 1. 查询快。对于长度为m的键值，最坏情况下只需花费O(m)的时间；而BST最坏情况下需要O(m log n)的时间
 * 2. 当存储大量字符串时，Trie耗费的空间较少。因为键值并非显式存储的，而是与其他键值共享子串。
 */

class Node {
    constructor(){
        this.val = null;
        this.next = [];
    }
}

class TriseST {
    constructor(){
        this.R = 256;
        this.root = null;
    }  

    get(key){
        let x = this._get(this.root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    _get(x, key, d){
        if (x === null) return null;
        if (d === key.length) return x;
        let c = key[d];
        return this._get(x.next[c], key, d+1)
    }

    put(key, val){
        this.root = this._put(this.root, key, val, 0)
    }

    _put(x, key, val, d){
        if (x === null || x === undefined) x = new Node();
        if (d === key.length) { x.val = val; return x;}
        let c = key[d];
        x.next[c] = this._put(x.next[c], key, val, d+1);
        return x;
    }

    print(){
        this._print(this.root);
    }

    _print(x){
        let keys = Object.keys(x.next);
        console.log(x.next)
        if (keys.length > 0){
            for (let key of keys){
                this._print(x.next[key]);
            }
        }
    }
}

let triseSt = new TriseST();
triseSt.put("she", 0);
triseSt.put("sells", 1);
triseSt.put("sea", 2);
triseSt.put("shells", 3);
triseSt.put("by", 4);
triseSt.put("the", 5);
triseSt.put("sea", 6);
triseSt.put("shore", 7);


console.log(triseSt.get("sea"));
console.log(triseSt.get("she"));
console.log(triseSt.get("shells"));