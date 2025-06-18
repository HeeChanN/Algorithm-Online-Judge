import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n;
    static int[] arr = new int[1004];
    static int[] dp = new int[1004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 1; i<=n;i++){
            arr[i] = fs.nextInt();
        }
        
        for(int i = 1;i<=n;i++){
            int num = arr[i];
            for(int j = i;j<=n;j++){
                dp[j] = Math.max(dp[j],dp[j-i] + num);
            }

        }
        System.out.print(dp[n]);
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
