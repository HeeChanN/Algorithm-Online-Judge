import java.util.*;
import java.io.*;

class Main {
    
    static final int MOD = 10007;
    
    static FastScanner fs = new FastScanner();
    
    static int n;
    static int[] dp = new int[1004];
    
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % MOD;
        }
        System.out.print(dp[n]);
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
