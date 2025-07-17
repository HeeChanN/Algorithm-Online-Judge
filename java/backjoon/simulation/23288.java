import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m,k;
    static int[][] board = new int[24][24];
    static int[][] score = new int[24][24];
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int dir = 1;
    static int [] dice = {2,4,1,3,5,6};
    static int [] p = {0,0};
    
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                 board[i][j] = fs.nextInt();
            }
        }
        
        for(int i  =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(score[i][j] == 0){
                    bfs(i,j);
                }
            }
        }
        for(int i = 0; i<k;i++){
            int ny = p[0] + dy[dir];
            int nx = p[1] + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >=m){
                dir = (dir + 2) % 4;
                ny = p[0] + dy[dir];
                nx = p[1] + dx[dir];
            }
            ret+= score[ny][nx];
            changeDice();
            changeDir(ny,nx);
            p[0] = ny;
            p[1] = nx;
        }
        System.out.print(ret);
    }
    // dice[5]
    static void changeDir(int y, int x){
        if(dice[5] > board[y][x] ){
            dir = (dir + 1) % 4;
        }
        else if (dice[5] < board[y][x]){
            dir = (4 + dir - 1) % 4;
        }
    }
    
    static void changeDice(){
        int tmp;
        if(dir == 0){
            tmp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = tmp;
        }
        else if (dir == 1){
            tmp = dice[5];
            dice[5] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = tmp;
        }
        else if (dir == 2){
            tmp = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[0];
            dice[0] = tmp;
        }
        else{
            tmp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = tmp;
        }
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> store = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        store.offer(new int[]{y,x});
        score[y][x] = 1;
        int cnt = 1;
        int num = board[y][x];
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >=m || num != board[ny][nx]){
                    continue;
                }
                if(score[ny][nx] == 0){
                    score[ny][nx] = 1;
                    q.offer(new int[]{ny,nx});
                    store.offer(new int[]{ny,nx});
                    cnt++;
                }
            }
        }
        while(!store.isEmpty()){
            int [] pos = store.poll();
            int py = pos[0];
            int px = pos[1];
            score[py][px] = cnt * num;
        }
    }
    
    static void print(){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(score[i][j] + " ");
            }
            System.out.println();
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
