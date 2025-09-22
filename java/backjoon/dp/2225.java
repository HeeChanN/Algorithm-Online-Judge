import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static final int MOD = 1000000000;
    
    static int n,k;
    static int [][]dp = new int[204][204];
    static int [] psum = new int[204];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<=k;i++){
            dp[0][i] = 1;
        }
        
        for(int i = 1; i<=n;i++){
            Arrays.fill(psum, 0);
            for(int j = 1; j<=k;j++){
                psum[j] = (psum[j] + dp[i-1][j]) % MOD;
                dp[i][j] = (dp[i][j-1] + psum[j]) % MOD;
            }
        }
        System.out.print(dp[n][k]);
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
