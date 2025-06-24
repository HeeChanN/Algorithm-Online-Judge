import java.util.*;
import java.io.*;

class Main {
    
    static class Pair{
        int y,x;
        
        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int idx = 1;
    static int ret = 987654321;
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int [][] board = new int[101][101];
    static int [][] visited = new int[101][101];
    static ArrayList<Pair> islands = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                board[i][j] = fs.nextInt();
                if(board[i][j] == 1){
                    islands.add(new Pair(i,j));
                }
            }
        }
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(visited[i][j] == 0 && board[i][j] == 1){
                    bfs(i,j);
                    idx++;
                }
            }
        }
        
        int l = 1;
        int r = 2 * n;
        while(l <= r){
            int mid = l + (r-l)/2;
            int flag = 0;

            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){
                    if(board[i][j] == 1){
                        if(checkPossible(i,j,mid)){
                            flag = 1;
                        }
                    }
                }
            }
            if(flag == 1){
                r = mid - 1;
                ret = Math.min(ret, mid);
            }
            else{
                l = mid + 1;
            }
        }
        System.out.print(ret);
    }
    
    static boolean checkPossible(int y, int x, int mid){
        for(Pair p : islands){
            if(visited[p.y][p.x] == visited[y][x]){
                continue;
            }
            int result = Math.abs(y-p.y) + Math.abs(x - p.x) -1;
            if(mid >= result){
                return true;
            }
        }
        return false;
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = idx;
        q.offer(new int[]{y,x});
        
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx =px + dx[i];
                if(ny < 0 || nx < 0 || ny >=n || nx >= n || board[ny][nx] == 0){
                    continue;
                }
                if(visited[ny][nx] != idx){
                    visited[ny][nx] = idx;
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
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
