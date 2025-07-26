//https://www.acmicpc.net/problem/12920

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,m;
    
    static int [] w = new int[104];
    static int [] like = new int[104];
    static int [] cnt = new int[104];
    static int [] dp = new int[10004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            w[i] = fs.nextInt();
            like[i] = fs.nextInt();
            cnt[i] = fs.nextInt();
        }
        
        for(int i = 0;i <n;i++){
            int pw = w[i];
            int v = like[i];
            int c = Math.min(cnt[i], m/pw);
            for(int k = 1; c>0;k = k*2){
                int use = Math.min(k, c);
                int W = pw * use;
                int V = v * use;
                for (int j = m; j >= W; j--) {
                    dp[j] = Math.max(dp[j], dp[j - W] + V);
                }
                c -= use;
            }
        }
        System.out.print(dp[m]);
    }
    
    static class FastScanner{
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
