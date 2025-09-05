import java.io.*;
import java.util.*;

// 치즈버거 요구 개수, 감자튀김 요구 개수
// 원하는 주문 처리 가능
// 최선의 방법으로 주문을 선택해 최대 몇 개의 주문을 처리 할 수 있나?


class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,m,k;
    static int dp[][] = new int[304][304];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        dp[0][0] = 1;
        for(int t =0 ; t<n;t++){
            int burger = fs.nextInt();
            int potato = fs.nextInt();
            for(int i = m; i>=burger;i--){
                for(int j = k; j>=potato;j--){
                    if(dp[i-burger][j-potato] != 0){
                        dp[i][j] = Math.max(dp[i][j],dp[i-burger][j-potato] + 1);
                    }
                }
            }
            // for(int i = 0; i<=m;i++){
            //     for(int j = 0; j<=k;j++){
            //         System.out.print(dp[i][j] + " ");
            //     }
            // }
            // System.out.println();
        }
        int ret = 1;
        for(int i = 0; i<=m;i++){
            for(int j = 0; j<=k;j++){
                ret = Math.max(ret, dp[i][j]);
            }
        }
        System.out.print(ret - 1);
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
