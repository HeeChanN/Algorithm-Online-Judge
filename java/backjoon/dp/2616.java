import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static int [] arr = new int[50004];
    static int [][] dp = new int[4][50004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            arr[i] = arr[i-1] +  fs.nextInt();
        }
        m = fs.nextInt();
 
        for (int j = 1; j <= 3; j++) {

            for (int i = j * m; i <= n; i++) {
                int seg = arr[i] - arr[i - m];
                dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - m] + seg);
            }
        }

        System.out.println(dp[3][n]);
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
