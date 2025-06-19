import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int t,n;
    
    static int [] arr = new int[504];
    static int [] psum = new int[504];
    static int[][] dp = new int[504][504];
    
    public static void main(String[] args) throws Exception{
        t = fs.nextInt();
        for(int i = 0; i<t;i++){
            n = fs.nextInt();
            
            for(int j = 1;j<=n;j++){
                arr[j] = fs.nextInt();
                psum[j] = psum[j-1]+arr[j];
            }
            for(int len = 2; len<=n;len++){
                for(int l  = 1;l+len-1<=n;l++){
                    int r = l + len - 1;
                    dp[l][r] = 987654321;
                    int s = psum[r] - psum[l-1];
                    for(int j = l; j<r;j++){
                        dp[l][r] = Math.min(dp[l][r], dp[l][j] + dp[j+1][r] + s);
                    }
                }
            }
            sb.append(dp[1][n]).append("\n");
            for(int [] row : dp){
                Arrays.fill(row, 0);
            }
            Arrays.fill(psum,0);
        }
        System.out.print(sb);
    }

    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st= new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
