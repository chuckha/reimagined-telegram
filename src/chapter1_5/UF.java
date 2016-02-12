package chapter1_5;

import java.util.Scanner;

public class UF {
    private int[] id;     // access to component id (site indexed)
    private int[] sz;
    private int count;    // number of components

    public UF(int N) {  // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    /** weighted quick union **/
    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }

    /** quick-union
    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }
    **/

    /*   quick-find
    private int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
     */

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        UF uf = new UF(N);
        while (stdin.hasNext()) {
            int p = stdin.nextInt();
            int q = stdin.nextInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }
}
