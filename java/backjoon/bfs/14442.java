//https://www.acmicpc.net/problem/14442

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m,k;
    static String[] board = new String[1004];
    static int [][][] dist = new int[11][1001][1001];
    static String tmp;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            board[i] = fs.next();
        }
        for(int i = 0;i<=k;i++){
            for(int j = 0; j<n;j++){
                for(int l = 0; l<m;l++){
                    dist[i][j][l] = 987654321;
                }
            }
        }
        
        bfs();
        int ret = 987654321;
        for(int i = 0; i<=k;i++){
            ret = Math.min(ret, dist[i][n-1][m-1]);
        }
        if(ret == 987654321){
            System.out.print("-1");
        }
        else{
            System.out.print(ret);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{k,0,0});
        dist[k][0][0] = 1;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int cnt = pos[0];
            int py = pos[1];
            int px = pos[2];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                    continue;
                }
                if(board[ny].charAt(nx) == '1' && cnt > 0){
                    if(dist[cnt-1][ny][nx] > dist[cnt][py][px]+ 1){
                        dist[cnt-1][ny][nx] = dist[cnt][py][px] + 1;
                        q.offer(new int[]{cnt-1,ny,nx});
                    }
                }
                else if(board[ny].charAt(nx) == '0'){
                    if(dist[cnt][ny][nx] > dist[cnt][py][px] + 1){
                        dist[cnt][ny][nx] = dist[cnt][py][px] + 1;
                        q.offer(new int[]{cnt,ny,nx});
                    }
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
