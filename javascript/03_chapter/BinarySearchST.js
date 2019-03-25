/**
 * 顺序查找（基于有序数组）
 */
class BinarySearchST {
    constructor(){
        this.keys = [];
        this.vals = [];
    }

    print(){
        for (let i = 0 ; i < this.keys.length; i++){
            console.log(this.keys[i]);
        }
    }

    get(key){
        for (let i = 0; i < this.keys.length; i++){
            if (this.keys[i] === key){
                return i;
            }
        }
    }

    rank(key){
        let lo = 0, hi = this.keys.length - 1;
        while (lo <= hi){
            let mid = lo + parseInt((hi - lo) / 2);
            let midKey = this.keys[mid]
            if ( key < midKey) {
                hi = mid - 1;
            } else if ( key > midKey) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    put(key, val){
        let i = this.rank(key);
        if (i && this.keys[i] === key){
            this.vals[i] = val;
        } else {
            for (let j = this.vals.length; j > i; j--){
                this.keys[j] = this.keys[j-1];
                this.vals[j] = this.vals[j-1];
            }
            this.keys[i] = key;
            this.vals[i] = val;
        }
    }
}

let st = new BinarySearchST();
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

console.log(st.get('A'))
console.log(st.get('C'))
console.log(st.get('M'))
console.log(st.get('S'))
console.log(st.get('X'))

