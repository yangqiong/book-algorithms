/**
 * 顺序查找（基于无序列表）
 */

class Node {
    constructor(key, val, next){
        this.key = key;
        this.value = val;
        this.next = next;
    }
}

class SequentialSearchST {
    constructor(){
        this.first = null;
    }

    get(key){
        for (let x = this.first; x != null; x = x.next){
            if (x.key === key){
                return x.value
            }
        }
        return null;
    }

    put(key, val){
        for (let x = this.first; x != null; x = x.next){
            if (x.key === key){
                x.value = val;
                return;
            }
        }
        this.first = new Node(key, val, this.first);
    }
}

let dict = {
    'S': 0,
    'E': 1,
    'A': 2,
    'R': 3,
    'C': 4,
    'H': 5,
    'E': 6,
    'X': 7,
    'A': 8,
    'M': 9,
    'P': 10,
    'L': 11,
    'E': 12
};

let st = new SequentialSearchST();
let keys = Object.keys(dict);
for (let key of keys){
    st.put(key, dict[key]);
}

for (let key of keys){
    console.log(key, st.get(key))
}