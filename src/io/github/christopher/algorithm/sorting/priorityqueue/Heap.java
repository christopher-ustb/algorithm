package io.github.christopher.algorithm.sorting.priorityqueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Christopher.Wang 2017/9/11.
 */
public class Heap {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) { // N/2是堆中从右向左第一个不是最末端节点（有子节点）的节点索引
            sink(a, k, N);
        }
        // 以上成功构造出有序堆
        while (N >= 1) {
            exch(a, 1, N--); // 将最大元素交换至数组尾部，并将堆范围缩小
            sink(a, 1, N); // sink整理缩小后的堆使其有序
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) { // 直到触底，如果2*k>N则表示k元素没有子节点，即已到达底部
            int j = 2 * k; // j为当前节点的两个子节点中的左节点
            if (j < N && less(j, j + 1)) { // j<N则j+1<=N，即存在右子节点；且j比j+1小
                j ++; // 将交换节点更换为子节点中的右节点
            }
            if (!less(k, j)) { // 如果k>=j（2个子节点中的较大值），则停止下沉
                break;
            }
            exch(a, k, j); // 交换元素--下沉
            k = j; // 将当前关注节点的索引改为较大子节点的
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
