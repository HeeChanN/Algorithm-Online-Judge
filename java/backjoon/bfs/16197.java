// https://www.acmicpc.net/problem/16197
import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static String [] board = new String[21];
    static int num;
    static ArrayList<int[]> coins = new ArrayList<>();
    static int [][][][] visited = new int[21][21][21][21];
    static int ret = 987654321;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int[][][] a : visited){
            for(int [][] b : a){
                for(int [] c : b){
                    Arrays.fill(c,987654321);
                }
            }
        }
        
        for(int i = 0; i<n;i++){
            board[i] = fs.next();
            for(int j = 0; j<m;j++){
                if(board[i].charAt(j) == 'o'){
                    coins.add(new int[]{i,j});
                }
            }
        }
        bfs();
        if(ret == 987654321){
            System.out.print("-1");
        }
        else{
            System.out.print(ret);
        }
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        int ay = coins.get(0)[0];
        int ax = coins.get(0)[1];
        int by = coins.get(1)[0];
        int bx = coins.get(1)[1];
        q.offer(new int[]{ay,ax,by,bx});
        visited[ay][ax][by][bx] = 0;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            ay = pos[0];
            ax = pos[1];
            by = pos[2];
            bx = pos[3];
            if(ay == by && ax == bx){
                continue;
            }
            for(int i = 0; i<4;i++){
                int nay = ay + dy[i];
                int nax = ax + dx[i];
                int nby = by + dy[i];
                int nbx = bx + dx[i];
                // 둘다 떨어지는 경우
                if(checkOut(nay,nax) && checkOut(nby,nbx)){
                    continue;
                }
                if(checkOut(nay,nax) || checkOut(nby,nbx)){
                    ret = visited[ay][ax][by][bx] + 1;
                    return;
                }
                if(board[nay].charAt(nax) == '#'){
                    nay = nay - dy[i];
                    nax = nax - dx[i];
                }
                if(board[nby].charAt(nbx) == '#'){
                    nby = nby - dy[i];
                    nbx = nbx - dx[i];
                }
                if(visited[nay][nax][nby][nbx] < visited[ay][ax][by][bx] + 1){
                    continue;
                }
                if(visited[ay][ax][by][bx] == 9){
                    continue;
                }
                visited[nay][nax][nby][nbx] = visited[ay][ax][by][bx] + 1;
                q.offer(new int[]{nay,nax,nby,nbx});
            }
        }
    }
    
    static boolean checkOut(int y, int x){
        if(y < 0 || x < 0 || y >= n || x >= m){
            return true;
        }
        return false;
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
