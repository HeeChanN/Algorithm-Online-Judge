import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int N,q;
    static int n = 1;
    static int ret1 = 0;
    static int ret2 = 0;
    
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    
    static int [][] board = new int[70][70];
    static int [][] tmp = new int[70][70];
    static int [][] visited = new int[70][70];
    
    public static void main(String[] args) throws Exception{
        N = fs.nextInt();
        q = fs.nextInt();
        for(int i = 0;i<N;i++){
            n = n * 2;
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
            }
        }
        for(int i = 0; i<q;i++){
            int level = fs.nextInt();
            int l = 1;
            for(int j = 0; j<level; j++){
                l = l * 2;
            }
            moveBoard(l);
            meltIce();
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                ret1 += board[i][j];
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j] == 0 && board[i][j] != 0){
                    ret2 = Math.max(ret2,bfs(i,j));
                }
            }
        }
        System.out.println(ret1);
        System.out.println(ret2);
    }
    
    static void moveBoard(int l){
        for(int i = 0; i<n;i = i+l){
            for(int j = 0; j<n;j = j + l){
                rotate_90_right(i,j,l);
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = tmp[i][j];
            }
        }
    }
    
    static void rotate_90_right(int sy, int sx, int l){
        for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    tmp[sy + i][sx + j] = board[sy + l -1 -j][sx + i];
                }
            }
    }
    
    static void meltIce(){
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                tmp[i][j] = board[i][j];
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j] != 0){
                    checkIce(i,j);
                }
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = tmp[i][j];
            }
        }
    }
    
    static void checkIce(int y, int x){
        int cnt = 0;
        for(int i = 0; i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >=n || nx >=n){
                continue;
            }
            if(board[ny][nx] != 0){
                cnt++;
            }
        }
        if(cnt < 3){
            tmp[y][x]--;
        }
    }
    
    static int bfs(int y, int x){
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = 1;
        q.offer(new int[]{y,x});
        
        while(!q.isEmpty()){
            int [] p = q.poll();
            int py = p[0];
            int px = p[1];
            for(int i = 0;i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >=n){
                    continue;
                }
                if(board[ny][nx] == 0){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = 1;
                    q.offer(new int[]{ny,nx});
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
