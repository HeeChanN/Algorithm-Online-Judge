import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int n,k;
    static int [] arr = new int[104];
    static int [] dp = new int[100004];
    
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        k = fs.nextInt();
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        
        
        for(int i = 0; i<n;i++){
            for(int j = k; j>=arr[i];j--){
                dp[j] = Math.min(dp[j], 1 + dp[j-arr[i]]);
            }
        }
        if(dp[k] == 987654321){
            System.out.print(-1);
        }
        else{
            System.out.print(dp[k]);
        }
    }

    static void print(){
        for(int i = 0; i<=k;i++){
            System.out.print(dp[i] + " ");
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
