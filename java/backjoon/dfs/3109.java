import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    
    static int []dy = {-1,0,1};
    static int []dx = {1,1,1};
    
    static String tmp;
    static char[][] board = new char[10004][504];
    static int[][] visited = new int[10004][504];
    
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            tmp = fs.next();
            for(int j=0;j<tmp.length();j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        
        for(int i = 0; i<n;i++){
            dfs(i,0);
        }
        System.out.print(ret);
    }
    
    static boolean dfs(int y, int x){
        if(x == m-1){
            ret++;
            return true;
        }
    
        for(int i = 0;i<3;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >=n || board[ny][nx] == 'x' || visited[ny][nx] == 1) {
                continue;
            }
            visited[ny][nx] = 1;
            if (dfs(ny, nx)) {
                return true;
            }
        }
        return false;
    }
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        Integer nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
