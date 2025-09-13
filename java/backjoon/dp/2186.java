import java.util.*;
import java.io.*;

class Main {
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m,k;
    static String [] board = new String[104];
    static String code;
    
    static int [][][] dp = new int[84][104][104];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            board[i] = fs.next();
        }
        code = fs.next();
        int ret = 0;
        for(int [][] arr : dp){
            for(int [] row : arr){
                Arrays.fill(row,-1);
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(board[i].charAt(j) == code.charAt(0)){
                    ret += go(i,j,1);
                }
            }
        }
        System.out.print(ret);
    }
    
    static int go(int y, int x, int cnt){
        if(cnt == code.length()){
            return dp[cnt][y][x] = 1;
        }
        if(dp[cnt][y][x] != -1){
            return dp[cnt][y][x];
        }
        dp[cnt][y][x] = 0;
        for(int i = 1;i<=k;i++){
            for(int j = 0; j<4;j++){
                int ny = y + dy[j] * i;
                int nx = x + dx[j] * i;
                if(ny < 0 || nx < 0 || ny >=n || nx >=m){
                    continue;
                }
                if(board[ny].charAt(nx) == code.charAt(cnt)){
                    dp[cnt][y][x] += go(ny,nx,cnt+1);
                }
            }
        }
        return dp[cnt][y][x];
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
        
        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
