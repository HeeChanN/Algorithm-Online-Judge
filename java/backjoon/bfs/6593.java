import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static int [] dy = {-1,0,1,0,0,0};
    static int [] dx = {0,1,0,-1,0,0};
    static int [] dz = {0,0,0,0,1,-1};
    
    static char[][][] building = new char[31][31][31];
    static int [][][] visited = new int[31][31][31];
    
    static int l,r,c;
    static String str;
    static int[] start = new int[3];
    static int[] end = new int[3];
    
    public static void main(String[] args) throws Exception {
        
        while(true){
            l = fs.nextInt();
            r = fs.nextInt();
            c = fs.nextInt();
            if(l == 0 && r == 0 && c == 0){
                break;
            }
            for(int i = 0; i<l; i++){
                for(int j = 0; j<r;j++){
                    str = fs.next();
                    for(int k = 0; k<c;k++){
                        building[i][j][k] = str.charAt(k);
                        if(building[i][j][k] == 'S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                        else if (building[i][j][k] == 'E'){
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                    }
                }
                fs.nextLine();
            }
            bfs();
            clearVisited();
        }
        System.out.print(sb);
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]][start[2]] = 1;
        
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int z = pos[0];
            int y = pos[1];
            int x = pos[2];
            
            for(int i = 0; i<6;i++){
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c || building[nz][ny][nx] == '#'){
                    continue;
                }
                
                if(visited[nz][ny][nx] == 0){
                    visited[nz][ny][nx] = visited[z][y][x] + 1;
                    q.offer(new int[]{nz,ny,nx});
                }
                if(building[nz][ny][nx] == 'E'){
                    break;
                }
            }
        }
        int ret = visited[end[0]][end[1]][end[2]];
        if(ret == 0){
            sb.append("Trapped!\n");
        }
        else{
            sb.append("Escaped in ").append(ret-1).append(" minute(s).\n");            
        }
    }
    
    static void clearVisited(){
        for(int [][] floor : visited){
            for(int [] row : floor){
                Arrays.fill(row,0);
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
        
        String nextLine() throws Exception { 
            return br.readLine(); 
        }
    }
}
