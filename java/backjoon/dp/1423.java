import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,d;
    static int [] cnt = new int[54];
    static long [] str = new long[54];
    static long [] dp = new long[104];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();

        for (int i = 0; i < N; i++) {
            cnt[i] = fs.nextInt();
        }
        long ret = 0;
        for (int i = 0; i < N; i++) {
            str[i] = fs.nextInt();
            ret += (long) cnt[i] * str[i];
        }
        d = fs.nextInt();
        
        for (int level = 0; level < N - 1; level++) {
            int copies = Math.min(cnt[lvl], D);
            for (int m = 0; m < copies; m++) {
                long[] next = dp.clone();
                for (int target = level + 1; target < N; target++) {
                    int w = tgt - lvl;
                    if (w > D) break;
                    long v = str[tgt] - str[lvl];
                    for (int t = D; t >= w; --t) {
                        next[t] = Math.max(next[t], dp[t - w] + v);
                    }
                }
                dp = next;
            }
        }
        System.out.println(base + dp[D]);
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
