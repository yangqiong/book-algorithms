/**
 * 插入排序
 */
class Insertion {
    static sort( a = []) {
        const N = a.length;
        for (let i = 1; i < N; i++){
            for (let j = i; j >= i; j--){
                if (a[j] < a[j-1]){
                    this.exch(a, j, j-1);
                }
            }
        }
    }

    static exch(a, i, j){
        [a[j], a[i]] = [a[i], a[j]];
    }
}

let a = ['S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'];
console.log(a);
Insertion.sort(a);
console.log(a);
