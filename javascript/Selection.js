/**
 * 选择排序
 */
class Selection {
    static sort( a = []) {
        const N = a.length;
        for (let i = 0; i < N; i++){
            let min = i;
            for (let j = i + 1; j < N; j++){
                if (a[j] < a[min]) {
                    min = j
                }
            }
            this.exch(a, i, min)
        }
    }

    static exch(a, j, min){
        [a[j], a[min]] = [a[min], a[j]];
    }
}

let a = ['S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'];
console.log(a);
Selection.sort(a);
console.log(a);
