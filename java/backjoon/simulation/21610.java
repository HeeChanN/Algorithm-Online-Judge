import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int [] dy = {0,-1,-1,-1,0,1,1,1};
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    
    static int n,m;
    static int d,s;
    static int [][] board = new int[54][54];
    static int [][] tmp = new int[54][54];
    static int [][] visited = new int [54][54];
    static Queue<int[]> q = new ArrayDeque<>();
    
    
    public static void main(String[] args) throws Exception {
        init();
       for(int i = 0; i <m;i++){
           d = fs.nextInt();
           s = fs.nextInt();
           d = d-1;
           moveCloud();
           createCloud();
       }
       int ret =0 ;
       for(int i = 1; i<=n;i++){
           for(int j =1; j<=n;j++){
               ret += board[i][j];
           }
       }
       System.out.print(ret);
    }
    
    static void createCloud(){
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(visited[i][j] == 0 && board[i][j] >= 2){
                    q.offer(new int[]{i,j});
                    board[i][j]-= 2;
                }
                if(visited[i][j] == 1){
                    visited[i][j] = 0;
                }
            }
        }
    }
    
    static void moveCloud(){
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            int ny = y;
            int nx = x;
            for(int i = 0; i<s;i++){
                ny = ny + dy[d];
                nx = nx + dx[d];
                if(ny == 0){
                    ny = n;
                }
                else if (ny > n){
                    ny = 1;
                }
                if(nx == 0){
                    nx = n;
                }
                else if (nx > n){
                    nx = 1;
                }
            }
            board[ny][nx]++;
            visited[ny][nx] = 1;
        }
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(visited[i][j] == 1){
                    for(int k = 1;k<8;k= k +2){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 1 || nx < 1 || ny > n || nx > n || board[ny][nx] == 0){
                            continue;
                        }
                        board[i][j]++;
                    }
                }
            }
        }
    }
    
    static void init() throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
       for(int i = 1; i<=n;i++){
           for(int j = 1; j<=n;j++){
               board[i][j] = fs.nextInt();
           }
       }
       
       q.offer(new int[]{n,1});
       q.offer(new int[]{n,2});
       q.offer(new int[]{n-1,1});
       q.offer(new int[]{n-1,2});
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
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
