package chapter1_5;

import java.util.Scanner;

public class QuickFindUF {
    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public QuickFindUF(int N) {  // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

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

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
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

