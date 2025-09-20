import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static long [] dp = new long[34];
    
    static int n;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        dp[0] = 1;
        dp[2] = 3;
        
        long s = dp[0];
        
        for(int i = 4;i<=30;i=i+2){
            s += dp[i-2];
            dp[i] = dp[i-2] + (s * 2);
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
