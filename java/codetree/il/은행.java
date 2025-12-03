import java.util.*;

public class Main {
    
    static int [] dp = new int[10004];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        dp[0] = 0;
        // 가치의 합 최대가 되도록 
        for(int i = 0; i<n;i++){
            for(int j = m; j-w[i] >= 0;j--){
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }
        System.out.print(dp[m]);
    }

    static void print(int m){
        for(int i = 0; i<=m;i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
