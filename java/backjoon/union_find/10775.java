import java.io.*;
import java.util.*;

class Main {
    static FastScanner fs = new FastScanner();
    static int g, p;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        g = fs.nextInt();
        p = fs.nextInt();
        parent = new int[g + 1];
        
        for (int i = 0; i <= g; i++){ parent[i] = i; 
        
            
        }
        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int want = fs.nextInt();
            int root = find(want);
            if (root == 0) {
                break;
            }
            union(root, root - 1);
            cnt++;
        }
        System.out.print(cnt);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a); 
        b = find(b);
        parent[a] = b;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws Exception { return Integer.parseInt(next()); }
    }
}
