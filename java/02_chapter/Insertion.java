/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++){
            for (j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }
    }
}