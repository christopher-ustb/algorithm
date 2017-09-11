package io.github.christopher.algorithm.sorting.priorityqueue;

/**
 * @author Christopher.Wang 2017/9/8.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N --);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1) { // 直到登顶，如果k=1则停止上浮
            if (!less(k/2, k)) { // 如果父节点（k/2）大于等于当前元素（k）
                break; // 停止上浮
            }
            exch(k/2, k); // 交换元素--上浮
            k = k/2; // 将当前关注元素的索引变为父元素的
        }
    }

    private void sink(int k) {
        while (2 * k <= N) { // 直到触底，如果2*k>N则表示k元素没有子节点，即已到达底部
            int j = 2 * k; // j为当前节点的两个子节点中的左节点
            if (j < N && less(j, j + 1)) { // j<N则j+1<=N，即存在右子节点；且j比j+1小
                j ++; // 将交换节点更换为子节点中的右节点
            }
            if (!less(k, j)) { // 如果k>=j（2个子节点中的较大值），则停止下沉
                break;
            }
            exch(k, j); // 交换元素--下沉
            k = j; // 将当前关注节点的索引改为较大子节点的
        }
    }
}
