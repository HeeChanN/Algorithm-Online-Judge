// https://www.acmicpc.net/problem/16946
import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int idx = 1;
    static int[] dic = new int[500004];
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static String [] board = new String[1004];
    static ArrayList<int[]> walls = new ArrayList<>();
    static int[][] visited = new int[1004][1004];
    static int[][] arr = new int[1004][1004];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            board[i] = fs.next();
            for(int j = 0; j<m;j++){
                if(board[i].charAt(j) == '1'){
                    walls.add(new int[]{i,j});
                }
            }
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(board[i].charAt(j) == '0' && visited[i][j] == 0){
                    bfs(i,j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int [] wall : walls){
            int py = wall[0];
            int px = wall[1];
            int s = 0;
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >=m){
                    continue;
                }
                set.add(visited[ny][nx]);
            }
            for(int idx : set){
                s += dic[idx];
            }
            arr[py][px] = s + 1;
            set.clear();
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                sb.append(arr[i][j] % 10);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = idx;
        int cnt = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >= m || board[ny].charAt(nx) == '1'){
                    continue;
                }
                if(visited[ny][nx] == 0){
                    q.offer(new int[]{ny,nx});
                    visited[ny][nx] = idx;
                    cnt++;
                }
            }
        }
        dic[idx] = cnt;
        idx++;
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                System.out.print(visited[i][j] + " ");
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
