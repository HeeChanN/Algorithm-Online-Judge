import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] dp = new int[1000004];
    static final int MOD =  1000000007;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        dp[0] = 1;
        dp[1] = 2;
        int s = (dp[0]+dp[1]); 
        
        for(int i = 2;i<=n;i++){
            dp[i] = ((s * 2) % MOD + dp[i-2]) % MOD;
            s = (s + dp[i]) % MOD;
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
