import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static String [] board = new String[104];
    static int [][] visited = new int[104][104];
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int n;
    static int m;
    
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0;i<n;i++){
            String tmp = fs.next();
            board[i] = tmp;
        }
        System.out.print(bfs());
    }
    
    static int bfs(){
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
        
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny <0 || nx < 0 || ny >=n || nx >= m){
                    continue;
                }
                if(visited[ny][nx] == 0 && board[ny].charAt(nx) != '0'){
                    visited[ny][nx] = visited[py][px] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        return visited[n-1][m-1];
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
