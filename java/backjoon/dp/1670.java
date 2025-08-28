//https://www.acmicpc.net/problem/1670

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static long[] dp = new long[10004];
    
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        dp[0] = 1;
        dp[2] = 1;
        if(n == 2){
            System.out.print(1);
        }
        else{
            for(int i = 4;i<=n;i=i+2){
                for(int j = 2;j<=i;j=j+2){
                    dp[i] += (dp[j-2] * dp[i-j]);
                    dp[i] = dp[i] % 987654321;
                }
            }
            System.out.print(dp[n]);
        }
        
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
