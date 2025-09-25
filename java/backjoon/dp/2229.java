import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] arr = new int[1004];
    static int [] dp = new int[1004];
    static int [] maxV = new int[1004];
    static int [] minV = new int[1004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 1;i<=n;i++){
            arr[i] = fs.nextInt();
        }
        
        for(int i = 1; i<=n;i++){
            maxV[i] = arr[i];
            minV[i] = arr[i];
            for(int k = i-1;k>=1;k--){
                maxV[k] = Math.max(arr[k], maxV[k+1]);
                minV[k] = Math.min(arr[k], minV[k+1]);
            }

            for(int j = 0; j <i;j++){
                dp[i] = Math.max(dp[i],dp[j] + maxV[j+1] - minV[j+1]);

            }
        }
        System.out.println(dp[n]);
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
