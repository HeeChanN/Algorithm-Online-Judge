import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static char[][] board = new char[54][54];
    static int[][] tmp = new int[54][54];
    static int[][] visited = new int[54][54];
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static String line;
    
    static int sy,sx;
    static int ey, ex;
    
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            line = fs.next();
            for(int j = 0; j<line.length();j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'S'){
                    sy = i;
                    sx = j;
                }
                else if (board[i][j] == 'D'){
                    ey = i;
                    ex = j;
                }
            }
        }
        
        bfs();
        if(visited[ey][ex] == 0){
            System.out.print("KAKTUS");
        }
        else{
            System.out.print(visited[ey][ex]-1);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[sy][sx] = 1;
        q.offer(new int[]{sy,sx});
        while(!q.isEmpty()){
            moveWater();
            int limit = q.size();
            int t= 0;
            while(t < limit){
                int [] pos = q.poll();
                int y = pos[0];
                int x = pos[1];
                for(int i = 0; i<4;i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 'X' || board[ny][nx] == '*'){
                        continue;
                    }
                    if(visited[ny][nx] == 0){
                        q.offer(new int[]{ny,nx});
                        visited[ny][nx] = visited[y][x] + 1;
                    }
                }
                if(q.isEmpty()){
                    break;
                }
                t++;
            }
        }
    }
    
    static void moveWater(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(board[i][j] == '*'){
                    for(int k = 0;k<4;k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || nx < 0 || ny >=n || nx >=m || board[ny][nx] == 'X' || board[ny][nx] == 'D'|| board[ny][nx] == '*'){
                            continue;
                        }
                        tmp[ny][nx] = 1;
                    }
                }
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if(tmp[i][j] == 1){
                    board[i][j] = '*';
                }
            }
        }
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
