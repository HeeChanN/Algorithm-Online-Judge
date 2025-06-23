import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int n,m;
    
    static int[][] board = new int[21][21];
    static int [][]tmp = new int[21][21];
    static int[][] visited = new int[21][21];
    
    static int[] ret = new int[4];
    static int answer = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
            }
        }
        while(true){
            clearResult();
            // 블록 그룹 찾기
            for(int i =0; i<n;i++){
                for(int j = 0;j<n;j++){
                    if(board[i][j] >= 1 && board[i][j] < 6 && visited[i][j] != board[i][j]){
                        findBlockGroup(i,j);
                    }
                }
            }
            if(ret[2] <= 1){
                break;
            }
            // 블록 제거
            removeBlock(ret[0],ret[1]);
            answer += (ret[2] * ret[2]);
            
            // 중력
            gravity();
            rotate_90_left();
            gravity();
        }
        System.out.print(answer);
    }
    
    static void rotate_90_left(){
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                tmp[i][j] = board[j][n-i-1];
            }
        }
        for(int i = 0; i<n;i++){
            for(int j  =0; j<n;j++){
                board[i][j] = tmp[i][j];
            }
        }
    }
    
    static void gravity(){
        for(int i = n-1; i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(board[i][j] != -1 && board[i][j] != 6){
                    moveBlock(i,j);
                }
            }
        }
    }
    
    static void moveBlock(int y, int x){
        int py = y;
        int px = x;
        while(true){
            if(py == n-1){
                int tmp = board[y][x];
                board[y][x] = board[py][px];
                board[py][px] = tmp;
                break;
            }
            py = py + dy[2];
            if(board[py][px] == 6){
                continue;
            }
            int tmp = board[py-1][px];
            board[py-1][px] = board[y][x];
            board[y][x] = tmp;
            break;
        }
    }
    
    static void removeBlock(int y, int x){
        Queue<int[]> q =new ArrayDeque<>();
        int color = board[y][x];
        visited[y][x] = 6;
        board[y][x] = 6;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >= n || board[ny][nx] == -1) {
                    continue;
                }
                if(board[ny][nx] != 0 && board[ny][nx] != color){
                    continue;
                }
                if(visited[ny][nx] != 6){
                    visited[ny][nx] = 6;
                    board[ny][nx] = 6;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    static void findBlockGroup(int y, int x){
        Queue<int[]> q =new ArrayDeque<>();
        int color = board[y][x];
        int cnt = 1;
        int rainbow = 0;
        visited[y][x] = color;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >= n || board[ny][nx] == -1 || board[ny][nx] == 6){
                    continue;
                }
                if(board[ny][nx] != 0 && board[ny][nx] != color){
                    continue;
                }
                if(visited[ny][nx] != color){
                    visited[ny][nx] = color;
                    q.offer(new int[]{ny,nx});
                    cnt++;
                    if(board[ny][nx] == 0){
                        rainbow++;
                    }
                }
            }
        }
        if((ret[2] < cnt) 
        || (ret[2] == cnt && ret[3]<rainbow) 
        || (ret[2] == cnt && ret[3] == rainbow && ret[0] < y) 
        || (ret[2] == cnt && ret[3] == rainbow && ret[0] == y && ret[1]< x)){
            ret[0] = y;
            ret[1] = x;
            ret[2] = cnt;
            ret[3] = rainbow;
        }
    }
    
    static void clearResult(){
        ret[0] = 21;
        ret[1] = 21;
        ret[2] = 0;
        ret[3] = 0;
        for(int [] row : visited){
            Arrays.fill(row, 0);
        }
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void printV(){
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
