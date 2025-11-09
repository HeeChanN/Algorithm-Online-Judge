import java.util.*;
import java.io.*;


// 2계단, 3계단 이동 가능
// N층 높이의 계단에 올라가기 위한 서로 다른 방법의 수

// 탑다운 맞는 것 같음 
public class Main {

    static FastScanner fs = new FastScanner();
    static int n;
    static int [] dp  = new int[1005];

    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        dp[0] = 1;
        for(int i = 2;i <=n;i++){
            if(dp[i-2] != 0){
                dp[i] = (dp[i] + dp[i-2]) % 10007;
            }
            if(i-3 >= 0 && dp[i-3] != 0){
                dp[i] = (dp[i] + dp[i-3]) % 10007;
            }
        }
        // for(int i = 0; i<=n;i++){
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        if(dp[n] == 0){
            System.out.print("0");
        }
        else{
            System.out.print(dp[n] % 10007);
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
