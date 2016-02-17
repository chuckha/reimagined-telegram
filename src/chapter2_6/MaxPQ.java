package chapter2_6;

// A Max Priority Queue that accepts items that implement Comperable<Key> (Java's type bounds)
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        // We ignore the 0th item so we need the array to be 1 bigger than what we expect
        pq = (Key[]) new Comparable[maxN + 1];
    }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    // Always insert at the end
    public void insert(Key v) {
        // increment then access
        // [NULL, 0, 1, 2] N == 3 (we want to add to 4)
        pq[++N] = v;
        swim(N);
    }
    public Key delMax() {
        Key max = pq[1];
        // swap the last item and the max item
        exch(1, N--);
        // Delete the old max
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) { return pq[i].compareTo(pq[j]) < 0; }
    private void exch(int i, int j) { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }
    private void sink(int k) {
        // While we have children
        while (2*k <= N) {
            // get our left child index
            int j = 2*k;
            // if j is not the end of the bounds (at least 1 item away from the end)
            // and our right child is bigger than our left child, use the bigger one
            if (j < N && less(j, j+1)) j++;
            // If the bigger child is smaller than us, we're done
            if (!less(k, j)) break;
            // flip us and our larger child
            exch(k, j);
            k = j;
        }
    }
    private void swim(int k) {
        // while k is in bounds and k is less than its parent
        while (k > 1 && less(k/2, k)) {
            // swap them
            exch(k, k/2);
            k = k/2;
        }
    }
}
