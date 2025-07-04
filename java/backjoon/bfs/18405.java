import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,k,s,y,x;
    static int [][] board = new int[204][204];
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> a[0])
    );
    static Queue<int[]> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        k = fs.nextInt();
        
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j] = fs.nextInt();
                if(board[i][j] > 0){
                    pq.offer(new int[]{board[i][j],i,j});
                }
            }
        }
        
        s = fs.nextInt();
        y = fs.nextInt() - 1;
        x = fs.nextInt() - 1;
        
        while(!pq.isEmpty()){
            int [] pos = pq.poll();
            q.offer(pos);
        }
        
        int t = 0;
        while(t<s){
            int limit = q.size();
            for(int i =0;i<limit;i++){
                int [] pos = q.poll();
                int py = pos[1];
                int px = pos[2];
                for(int j = 0; j<4;j++){
                    int ny = py + dy[j];
                    int nx = px + dx[j];
                    if(ny < 0 || nx < 0 || ny >=n || nx >= n || board[ny][nx] != 0){
                        continue;
                    }
                    board[ny][nx] = pos[0];
                    q.offer(new int[]{pos[0],ny,nx});
                }
            }
            t++;
        }
        System.out.print(board[y][x]);
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
