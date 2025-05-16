import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int [][] dp = new int[1004][3]; 
    
    static int n;
    static int[][] arr = new int[1004][3];
    
    public static void main(String[] args) throws Exception{
        init();
        n = fs.nextInt();
        int total = 987654321;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<3;j++){
                arr[i][j] = fs.nextInt();
            }
        }
        for(int i = 0; i<3;i++){
            total = Math.min(total,go(1,i) + arr[0][i]);
        }
        System.out.print(total);
    }
    
    static int go(int pos, int last){
        if(pos == n){
            return 0;
        }
        if(dp[pos][last] != 987654321){
            return dp[pos][last];
        }
        for(int i = 0; i<3;i++){
            if(i == last){
                continue;
            }
            dp[pos][last] = Math.min(dp[pos][last], go(pos+1,i)+arr[pos][i]);
        }
        return dp[pos][last];
    }
    
    static void init(){
        for(int [] row : dp){
            Arrays.fill(row,987654321);
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
