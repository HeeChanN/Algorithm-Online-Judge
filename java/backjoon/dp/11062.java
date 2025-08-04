// https://www.acmicpc.net/problem/11062

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int t,n;
    static int [] arr = new int[1004];
    static int[][] dp = new int[1004][1004];
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int c = 0; c<t;c++){
            n = fs.nextInt();
            for(int i = 0; i<n;i++){
                arr[i] = fs.nextInt();
            }
            for(int len = 1; len<=n;len++){
                for(int i = 0; i+len-1<n;i++){
                    int j = i + len - 1;
                    
                    if(n%2==0){
                        if(len % 2 == 0){
                            dp[i][j] = geunwo(i,j);
                        }
                        else{
                            dp[i][j] = mungwo(i,j);
                        }
                    }
                    else{
                        if(len % 2== 0){
                            dp[i][j] = mungwo(i,j);
                        }
                        else{
                            dp[i][j] = geunwo(i,j);
                        }
                    }
                }
            }
            sb.append(dp[0][n-1]).append("\n");
            clearArr();
        }
        System.out.print(sb);
    }
    
    static int mungwo(int left, int right){
        if(left == right){
            return 0;
        }
        return Math.min(dp[left][right-1], dp[left+1][right]);
    }
    
    static int geunwo(int left, int right){
        if(left == right){
            return arr[left];
        }
        return Math.max(arr[right] + dp[left][right-1], arr[left] + dp[left+1][right]);
    }
    
    static void clearArr(){
        for(int i = 0; i<1004;i++){
            arr[i] = 0;
        }
        for(int [] row : dp){
            for(int i = 0; i<1004;i++){
                row[i] = 0;
            }
        }
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
