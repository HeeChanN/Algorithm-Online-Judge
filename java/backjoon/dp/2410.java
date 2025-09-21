import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static final int MOD = 1000000000;
    
    static int n;
    static int []dp = new int[1000004];
     
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        Arrays.fill(dp, 1);
        
        for(int i =2; i<1000000;i = i<<1){
            for(int j = i; j<=1000000;j++){
                dp[j] = (dp[j]+ dp[j-i])% MOD;
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
