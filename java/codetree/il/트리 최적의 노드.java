import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int n;
    static int[] down, up;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        down = new int[n + 1];
        up = new int[n + 1];

        dfsDown(1, 0);
        dfsUp(1, 0, 0); 

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int ecc = Math.max(down[i], up[i]);
            ans = Math.min(ans, ecc);
        }
        System.out.println(ans);
    }

    static void dfsDown(int u, int p) {
        int best = 0;
        for (int v : adj[u]) {
            if (v == p) continue;
            dfsDown(v, u);
            best = Math.max(best, down[v] + 1);
        }
        down[u] = best;
    }

    static void dfsUp(int u, int p, int parentBest) {
        up[u] = parentBest;

        int max1 = -1, max2 = -1;
        for (int v : adj[u]) {
            if (v == p) continue;
            int cand = down[v] + 1;
            if (cand > max1) { max2 = max1; max1 = cand; }
            else if (cand > max2) { max2 = cand; }
        }

        for (int v : adj[u]) {
            if (v == p) continue;
            int useSibling = (down[v] + 1 == max1) ? max2 : max1;
            int viaU = Math.max(parentBest, useSibling);
            int nextParentBest = viaU + 1; 
            dfsUp(v, u, nextParentBest);
        }
    }
}
