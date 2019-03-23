/**
 * 归并排序（自底向下）
 */

class Quick {
    static sort( a = []) {
        this.realSort(a, 0, a.length-1)
    };

    static realSort(a, lo, hi){
        if (hi <= lo){
            return;
        }
        var j = this.partition(a, lo, hi);
        this.realSort(a, lo, j-1)
        this.realSort(a, j+1, hi);
    }

    static partition(a, lo, hi){
        var v = a[lo];
        var i = lo, j = hi + 1;
        while(true){
            while(a[++i] < v){
                if (i == hi){
                    break;
                }
            }
            while(a[--j] > v){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            this.exch(a, i, j);
        }
        this.exch(a, lo, j);
        return j;
    }

    static exch(a, i, j){
        [a[j], a[i]] = [a[i], a[j]];
    }

}

let a = ['S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'];
console.log(a.join(','));
Quick.sort(a);
console.log(a.join(','));