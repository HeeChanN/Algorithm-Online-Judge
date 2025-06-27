import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m,c;
    static int a,b;
    static int[][] board = new int[24][24];
    static int[] taxi = new int[2];
    static int[] person = new int[3];
    static int[][] start = new int[24][24];
    static int[][] end = new int[404][2];
    
    static int[][] visited = new int[24][24];
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        c = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
            }
        }
        
        taxi[0] = fs.nextInt() - 1;
        taxi[1] = fs.nextInt() - 1;
        
        for(int i = 1;i<=m;i++){
            a = fs.nextInt() -1;
            b = fs.nextInt()-1;
            end[i][0] = fs.nextInt()-1;
            end[i][1] = fs.nextInt()-1;
            start[a][b] = i;
        }
        
        int t = 0;
        while(true){
            initPerson();
            selectPerson();
            if(person[2] == 987654321){
                c=-1;
                break;
            }
            c = c - person[2] + 1;
            initVisted();
            movePerson();
            if(!checkPossible()){
                c = -1;
                break;
            }
            initVisted();
            t++;
            if(t == m){
                break;
            }
        }
        System.out.print(c);
    }
    
    static boolean checkPossible(){
        int idx = start[person[0]][person[1]];
        int ey = end[idx][0];
        int ex = end[idx][1];
        if(visited[ey][ex] == 0){
            return false;
        }

        int need = visited[ey][ex] -1;
        c = c-need;
        if(c < 0){
            return false;
        }
        taxi[0] = ey;
        taxi[1] = ex;
        c = c + (need * 2);
        start[person[0]][person[1]] = 0;
        return true;
    }
    
    static void movePerson(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{person[0],person[1]});
        visited[person[0]][person[1]] = 1;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = visited[py][px] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    static void selectPerson(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[taxi[0]][taxi[1]] = 1;
        q.offer(new int[]{taxi[0],taxi[1]});
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            if(start[py][px] != 0){
                if((person[2] > visited[py][px]) || (person[2] == visited[py][px] && person[0] > py) || (person[2] == visited[py][px] && person[0] == py && person[1] > px)){
                    person[0] = py;
                    person[1] = px;
                    person[2] = visited[py][px];
                }
            }
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = visited[py][px] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    static void initVisted(){
        for(int [] row : visited){
            Arrays.fill(row, 0);
        }
    }
    
    static void initPerson(){
        person[0] = 21;
        person[1] = 21;
        person[2] = 987654321;
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
