import java.util.Scanner;
public class Main {

    static int [] dp = new int[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n;i++){
            for(int j = 1; j<=i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        System.out.print(dp[n]);
    }
}
