import java.util.*;
import java.io.*;

// 1차 풀이

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int [][] board = new int[1004][1004];
    static int [][][] dp = new int[3][1004][1004];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <=m;j++){
                board[i][j] = fs.nextInt();
            }
        }
        for(int [][] z : dp){
            for(int [] y : z){
                Arrays.fill(y,Integer.MIN_VALUE);
            }
        }
        
        dp[0][1][1] = board[1][1];
        for(int i = 2;i<=m;i++){
            dp[0][1][i] = dp[0][1][i-1] + board[1][i];
            dp[1][1][i] = dp[0][1][i-1] + board[1][i];
            dp[2][1][i] = dp[0][1][i-1] + board[1][i];
        }
        for(int i = 2; i<=n;i++){
            for(int j = 1;j<=m;j++){
                dp[0][i][j] = Math.max(dp[0][i][j-1],dp[1][i][j-1]);
                if(j != 1){
                    dp[0][i][j] += board[i][j];
                }
                dp[1][i][j] = Math.max(Math.max(dp[0][i-1][j], dp[1][i-1][j]),dp[2][i-1][j]) + board[i][j];
                int sum = board[i][j];
                for(int k = j+1; k<=m;k++){
                    sum += board[i][k];
                    int a = Math.max(Math.max(dp[0][i-1][k], dp[1][i-1][k]),dp[2][i-1][k]) + sum;
                    dp[2][i][j] = Math.max(dp[2][i][j], a);
                }
                
                // System.out.println(i + " " + j);
                // System.out.println(dp[0][i][j] + " " + dp[1][i][j] + " " + dp[2][i][j]);
            }
        }
        int ret = Math.max(Math.max(dp[0][n][m], dp[1][n][m]),dp[2][n][m]);
        System.out.print(ret);
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

// 2차 풀이

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int [][] board = new int[1004][1004];
    static int [][][] dp = new int[3][1004][1004];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 1; i<=n;i++){
            for(int j = 1; j <=m;j++){
                board[i][j] = fs.nextInt();
            }
        }
        for(int [][] z : dp){
            for(int [] y : z){
                Arrays.fill(y,Integer.MIN_VALUE);
            }
        }
        
        dp[0][1][1] = board[1][1];
        for(int i = 2;i<=m;i++){
            dp[0][1][i] = dp[0][1][i-1] + board[1][i];
            dp[1][1][i] = dp[0][1][i-1] + board[1][i];
            dp[2][1][i] = dp[0][1][i-1] + board[1][i];
        }
        for(int i = 2; i<=n;i++){
            for (int j = 1; j <= m; j++){
                dp[1][i][j] = Math.max(Math.max(dp[0][i-1][j],dp[1][i-1][j]),
                                        dp[2][i-1][j]) + board[i][j];
            }
            for(int j = 1;j<=m;j++){
                dp[0][i][j] = Math.max(dp[0][i][j-1],dp[1][i][j-1]);
                if(j != 1){
                    dp[0][i][j] += board[i][j];
                }
            }
            for(int j = m;j>=1;j--){
                dp[2][i][j] = Math.max(dp[2][i][j+1], dp[1][i][j+1]);
                if(j != m){
                    dp[2][i][j] += board[i][j];
                }
            }
        }
        int ret = Math.max(Math.max(dp[0][n][m], dp[1][n][m]),dp[2][n][m]);
        System.out.print(ret);
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
