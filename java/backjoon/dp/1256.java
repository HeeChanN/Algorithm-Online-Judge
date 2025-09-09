import java.io.*;
import java.util.*; 

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static long [][] dp = new long[204][104];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        go(n,m);
        
        if(dp[n][m] < k){
            System.out.print("-1");
        }
        else{
            int a = n;
            int b = m;
            while(true){
                if(a==0 || b == 0){
                    break;
                }
                if(dp[a-1][b] >= k){
                    sb.append('a');
                    a= a-1;
                }
                else if (dp[a-1][b] < k){
                    k -= dp[a-1][b];
                    b = b-1;
                    sb.append('z');
                }
            }
            while(a != 0){
                sb.append('a');
                a--;
            }
            while(b != 0){
                sb.append('z');
                b--;
            }
        
            System.out.print(sb);
        }
    }
    
    static long go(int a, int b){
        //System.out.println(a + " " + b);
        if(a == 0 || b == 0){
            dp[a][b] = 1;
            return 1;
        }
        if(dp[a][b] != 0){
            return dp[a][b];
        }
        long selectA = go(a-1, b);
        long selectB = go(a,b-1);
        long sum = selectA + selectB;
        if(sum > 1000000001){
            sum = 1000000001;
        }
        dp[a][b] = sum;
        //System.out.println(dp[a][b]);
        return dp[a][b];
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
