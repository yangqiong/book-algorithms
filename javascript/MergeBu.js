/**
 * 归并排序（自底向下）
 */

class MergeBu {
    static sort( a = []) {
        let N = a.length;
        for (let sz = 1; sz < N; sz = sz + sz){
            for (let lo = 0; lo < N - sz; lo += sz + sz){
                this.merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N-1));
            }
        }
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
MergeBu.sort(a);
console.log(a.join(','));