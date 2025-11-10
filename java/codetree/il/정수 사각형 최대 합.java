import java.util.*;

public class Main {

    static int[] dy = {1,0};
    static int[] dx = {0,1};

    static int [][] matrix;
    static int [][] dp = new int[104][104];
    static boolean [][] visited = new boolean[104][104];

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int [] row : dp){
            Arrays.fill(row,-987654321);
        }
        System.out.print(go(0,0));
    }

    static int go(int y, int x){
        if(y == n-1 && x == n-1){
            return matrix[y][x];
        }
        if(dp[y][x] != -987654321){
            return dp[y][x];
        }
        for(int i = 0; i<2;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >=n || nx < 0 || nx >= n || visited[ny][nx] == true){
                continue;
            }
            visited[ny][nx] = true;
            dp[y][x] = Math.max(dp[y][x], go(ny,nx));
            visited[ny][nx] = false;
        }
        dp[y][x] += matrix[y][x];
        return dp[y][x];
    }
}
