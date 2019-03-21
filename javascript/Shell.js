/**
 * 希尔排序
 */
class Shell {
    static sort( a = []) {
        const N = a.length;
        let h = 1;
        while ( h < N / 3) h = 3 * h + 1;
        while (h >= 1){
            for (let i = h; i < N; i++){
                for (let j = i; j >= h; j -= h){
                    if (a[j] < a[j-h]){
                        this.exch(a, j, j-h);
                    }
                }
            }
            h = parseInt(h / 3);
        }
    }

    static exch(a, i, j){
        [a[j], a[i]] = [a[i], a[j]];
    }
}

let a = ['S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'];
console.log(a.join(','));
Shell.sort(a);
console.log(a.join(','));
