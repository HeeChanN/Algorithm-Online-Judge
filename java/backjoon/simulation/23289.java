// https://www.acmicpc.net/problem/23289

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {0,0,0,-1,1};
    static int [] dx = {0,1,-1,0,0};
    
    static int [][] windDy = {
        {0,0,0},
        {-1,0,1},
        {-1,0,1},
        {-1,-1,-1},
        {1,1,1}
    };
    static int [][] windDx = {
        {0,0,0},
        {1,1,1},
        {-1,-1,-1},
        {-1,0,1},
        {-1,0,1}
    };
    
    static FastScanner fs = new FastScanner();
    static int n,m,k,num,w;
    static int [][][] board = new int[24][24][5];
    static ArrayList<int[]> hot = new ArrayList<>();
    static ArrayList<int[]> check = new ArrayList<>();

    static int[][] visited = new int[21][21];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        // 입력 받기
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                num = fs.nextInt();
                if(1<=num && num <=4){
                    hot.add(new int[]{i,j,num});
                }
                else if (num == 5){
                    check.add(new int[]{i,j});
                }
            }
        }
        
        // 벽관리 board[y][x][5] -> 1 ~ 4 범위는 벽, 0 은 값 저장
        w = fs.nextInt();
        for(int i = 0;i<w;i++){
            int y = fs.nextInt()-1;
            int x = fs.nextInt()-1;
            int t = fs.nextInt();
            if(t == 0){
                board[y][x][3] = 1;
                board[y-1][x][4] = 1;
            }
            else{
                board[y][x][1] = 1;
                board[y][x+1][2] =1;
            }
        }
        int choco = 0;
        while(true){
            // 1) 온풍기 동작
            activate();
            
            // 2) 온도 조절
            controlTemp();
            
            // 3) 가장자리 온도 -1
            removeEdgeTemp();
            
            // 4) choco + 1
            choco++;
            if(choco > 100){
                break;
            }
            
            // 5) 검사
            if(checkTemp()){
                break;
            }
        }
        System.out.print(choco);
    }
    
    static boolean checkTemp(){
        for(int [] cur : check){
            if(board[cur[0]][cur[1]][0] < k){
                return false;
            }
        }
        return true;
    }
    
    static void removeEdgeTemp() {
        // 상/하
        for (int j = 0; j < m; j++) {
            if (board[0][j][0] > 0) board[0][j][0]--;
            if (n > 1 && board[n - 1][j][0] > 0) board[n - 1][j][0]--;
        }
        // 좌/우 (코너 제외)
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0][0] > 0) board[i][0][0]--;
            if (m > 1 && board[i][m - 1][0] > 0) board[i][m - 1][0]--;
        }
    }
    
    static void controlTemp(){
        int[][] tmp = new int[21][21];
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                tmp[i][j] = board[i][j][0];
            }
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 1; k<=4;k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                        continue;
                    }
                    if(isWall(1,k,i,j,ny,nx)){
                        continue;
                    }
                    if(board[i][j][0] - board[ny][nx][0] > 0){
                        int v = (board[i][j][0] - board[ny][nx][0]) / 4;
                        if(v > 0){
                            tmp[i][j] -= v;
                            tmp[ny][nx] += v;
                        }
                    }
                }
            }
        }
       for(int i = 0; i<n;i++){
           for(int j = 0;j<m;j++){
               board[i][j][0] = tmp[i][j];
           }
       }
    }
    
    static void activate(){
        for(int [] h : hot){
            process(h[0], h[1], h[2]);
            for(int [] row : visited){
                Arrays.fill(row, 0);
            }
        }
    }
    
    static void process(int y, int x, int dir){
        Queue<int[]> q = new ArrayDeque<>();
        int sy = y + dy[dir];
        int sx = x + dx[dir];
        
        visited[sy][sx] = 5;
        board[sy][sx][0] += 5;
        q.offer(new int[]{sy, sx});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            for(int i = 0; i<3;i++){
                int ny = py + windDy[dir][i];
                int nx = px + windDx[dir][i];
                if(ny < 0 || nx < 0 || ny >=n || nx >= m || visited[ny][nx] != 0){
                    continue;
                }
                if(isWall(i,dir,py,px,ny,nx)){
                    continue;
                }
                board[ny][nx][0] += visited[py][px] - 1;
                visited[ny][nx] = visited[py][px] - 1;
                if(visited[ny][nx] == 1){
                    continue;
                }
                q.offer(new int[]{ny,nx});
            }
        }
    }
    
    static boolean isWall(int idx,int dir,int py, int px, int ny, int nx){
        if(idx == 0){ // left
            if(dir == 1 && (board[py][px][3] == 1 || board[ny][nx][2] == 1)){
                return true;
            }
            else if (dir == 2 && (board[py][px][3] == 1 || board[ny][nx][1] == 1)){
                return true;
            }
            else if (dir == 3 && (board[py][px][2] == 1 || board[ny][nx][4] == 1)){
                return true;
            }
            else if (dir == 4 && (board[py][px][2] == 1 || board[ny][nx][3] == 1)){
                return true;
            }
        }
        else if (idx == 1){ // middle
            if(dir == 1 && (board[py][px][1] == 1)){
                return true;
            }
            else if (dir == 2 && (board[py][px][2] == 1 )){
                return true;
            }
            else if (dir == 3 && (board[py][px][3] == 1 )){
                return true;
            }
            else if (dir == 4 && (board[py][px][4] == 1 )){
                return true;
            }
        }
        else{ // right
            if(dir == 1 && (board[py][px][4] == 1 || board[ny][nx][2] == 1)){
                return true;
            }
            else if (dir == 2 && (board[py][px][4] == 1 || board[ny][nx][1] == 1)){
                return true;
            }
            else if (dir == 3 && (board[py][px][1] == 1 || board[ny][nx][4] == 1)){
                return true;
            }
            else if (dir == 4 && (board[py][px][1] == 1 || board[ny][nx][3] == 1)){
                return true;
            }
        }
        return false;
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
