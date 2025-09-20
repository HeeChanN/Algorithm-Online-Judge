import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static final int MOD = 1000000009;
    
    static long [] dp = new long[1000004];
    
    static int t,n;
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 4;i<=1000000;i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }
        
        for(int i = 0; i<t;i++){
            n = fs.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
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
