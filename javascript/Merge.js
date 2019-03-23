/**
 * 归并排序（自顶向下）
 */

class Merge {
    static sort( a = []) {
        this.realsort(a, 0, a.length-1);
    };

    static realsort(a, lo,  hi){
        if (hi <= lo){
            return;
        }
        let mid = lo + parseInt((hi - lo) / 2)
        this.realsort(a, lo, mid);
        this.realsort(a, mid+1, hi);
        this.merge(a, lo, mid, hi);
    };

    static merge(a, lo, mid, hi){
        let aux = [...a];

        let i = lo, j = mid + 1;
        for (let k = lo; k <= hi; k++){
            if (i > mid){
                a[k] = aux[j++];
            } else if ( j > hi){
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]){
                a[k] = aux[j++]
            } else {
                a[k] = aux[i++]
            }
        }
    }
}

let a = ['S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'];
console.log(a.join(','));
Merge.sort(a);
console.log(a.join(','));