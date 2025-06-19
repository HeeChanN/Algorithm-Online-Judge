import java.util.*;
import java.io.*;

// 0 -> 공기
// 1 -> 치즈
// 2 -> 밖
// 3 -> 치즈 안
// 4 -> 지워질 치즈

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int n,m;
    static int cnt = 0;
    static int ret = 0;
    static int[][] board = new int [104][104];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                board[i][j] = fs.nextInt();
                if(board[i][j] == 1){
                    cnt++;
                }
            }
        }
        
        while(true){
            if(cnt == 0){
                break;
            }
            // 밖 체크
            bfs(0,0,2);
            
            // 안 체크
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(board[i][j] == 0){
                        bfs(i,j,3);
                    }
                }
            }
            
            // 지울 치즈 체크
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(board[i][j] == 1){
                        checkAround(i,j);
                    }
                }
            }
            
            // board 최신화
            for(int i = 0; i<n;i++){
                for(int j =0;j<m;j++){
                    if(board[i][j] == 2 || board[i][j] == 3){
                        board[i][j] = 0;
                    }
                    else if (board[i][j] == 4){
                        cnt--;
                        board[i][j] = 0;
                    }
                }
            }
            
            ret++;
        }
        System.out.print(ret);
    }
    
    static void checkAround(int y, int x){
        int air = 0;
        for(int i = 0; i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0 || nx < 0 || ny >= n || nx >= m){
                continue;
            }
            if(board[ny][nx] == 2){
                air++;
            }
        }
        if(air >=2){
            board[y][x] = 4;
        }
    }
    
    static void bfs(int y, int x, int v){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        board[y][x] = v;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 1){
                    continue;
                }
                if(board[ny][nx] == 0){
                    board[ny][nx] = v;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st= new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
