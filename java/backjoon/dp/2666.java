// https://www.acmicpc.net/problem/2666
import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int m;
    static int a,b;
    
    static int [] v = new int[24];
    static int [][][] dp = new int[22][22][22];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        a = fs.nextInt();
        b = fs.nextInt();
        m = fs.nextInt();

        for(int i = 0; i<m;i++){
            v[i] = fs.nextInt();
        }
        
        for(int [][] f : dp){
            for(int [] g : f){
                Arrays.fill(g,987654321);
            }
        }
        
        System.out.print(go(a,b,0));
    }
    
    static int go(int left, int right, int idx){
        if(idx == m){
            return 0;
        }
        if(dp[left][right][idx] != 987654321){
            return dp[left][right][idx];
        }
        if(left == v[idx] || right == v[idx]){
            return dp[left][right][idx] = go(left, right, idx+1);
        }
        int nextL = go(v[idx], right, idx+1) + Math.abs(v[idx] - left);
        int nextR = go(left, v[idx], idx+1) + Math.abs(v[idx] - right);
        
        return dp[left][right][idx] = Math.min(nextL, nextR);
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
