import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int[] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int n;
    static String[] board = new String[54];
    static int[][] visited = new int[52][52];
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i <n;i++){
            board[i] = fs.next();
        }
        for(int [] row : visited){
            Arrays.fill(row, 987654321);
        }
        go();
        System.out.print(visited[n-1][n-1]);
    }
    
    static void go(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 0;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            
            for(int i = 0 ;i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n){
                    continue;
                }
                int num = board[ny].charAt(nx) == '0' ? 1 : 0;
                if(visited[ny][nx] > visited[py][px] + num){
                    visited[ny][nx] = visited[py][px] + num;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
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
