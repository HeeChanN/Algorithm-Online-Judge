import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,k,x;
    
    static int[] arrA = new int[84];
    static int[] arrB = new int[84];
    static int[][] dp = new int[84][16004];
    static int sumA = 0;

    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        x = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            arrA[i] = fs.nextInt();
            arrB[i] = fs.nextInt();
            sumA += arrA[i];
        }
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        dp[0][0] = 0;
        
        for(int i = 0; i<n;i++){
            int a = arrA[i];
            int b = arrB[i];
            for(int c = Math.min(i, k-1); c>=0; c--){
                for(int j = sumA-a;j>=0;j--){
                    if(dp[c][j] == -1){
                        continue;
                    }
                    dp[c+1][j+a] =  Math.max(dp[c + 1][j + a], dp[c][j] + b);
                }
            }
        }
        long ans = -1;
        for (int i = 0; i <= sumA; i++) {
            if (dp[k][i] == -1) {
                continue;
            }
            ans = Math.max(ans, (long) i * (long) dp[k][i]);
        }
        if(ans == -1){
            System.out.println(0);
        }
        else{
            System.out.println(ans);
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
