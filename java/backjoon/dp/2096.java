import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int[][] arr = new int [100004][3];
    static int[][] dp = new int[100004][3];
    static int answer[] = new int[2];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            for(int j = 0; j<3;j++){
                arr[i][j] = fs.nextInt();
            }
        }
        calcMaxPoint();
        for(int [] tmp : dp){
            Arrays.fill(tmp,0);
        }
        calcMinPoint();
        
        System.out.print(answer[0] + " "+ answer[1]);
    }
    
    static void calcMinPoint(){
        dp[n][0] = arr[n][0];
        dp[n][1] = arr[n][1];
        dp[n][2] = arr[n][2];
        
        for(int i = n-1;i>=1;i--){
            for(int j=0;j<3;j++){
                dp[i][j] += calcMin(i,j) + arr[i][j];
            }
        }
        answer[1] = Math.min(dp[1][0], dp[1][1]);
        answer[1] = Math.min(answer[1], dp[1][2]);
    }
    
    static int calcMin(int i, int j){
        if(j == 0){
            return Math.min(dp[i+1][j], dp[i+1][j+1]);
        }
        else if (j == 1){
            int mid = Math.min(dp[i+1][j], dp[i+1][j+1]);
            return Math.min(mid, dp[i+1][j-1]);
        }
        else{
            return Math.min(dp[i+1][j-1], dp[i+1][j]);
        }
    }
    
    static void calcMaxPoint(){
        dp[n][0] = arr[n][0];
        dp[n][1] = arr[n][1];
        dp[n][2] = arr[n][2];
        
        for(int i = n-1;i>=1;i--){
            for(int j=0;j<3;j++){
                dp[i][j] += calcMax(i,j) + arr[i][j];
            }
        }
        answer[0] = Math.max(dp[1][0], dp[1][1]);
        answer[0] = Math.max(answer[0], dp[1][2]);
    }
    
    static int calcMax(int i, int j){
        if(j == 0){
            return Math.max(dp[i+1][j], dp[i+1][j+1]);
        }
        else if (j == 1){
            int mid = Math.max(dp[i+1][j], dp[i+1][j+1]);
            return Math.max(mid, dp[i+1][j-1]);
        }
        else{
            return Math.max(dp[i+1][j-1], dp[i+1][j]);
        }
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
