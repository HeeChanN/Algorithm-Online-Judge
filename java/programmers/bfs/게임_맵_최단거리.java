import java.util.*;

class Solution {
    
    static int [][] visited = new int[104][104];
    static int [][] map;
    static int n,m;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
        
    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = 1;
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i = 0; i<4;i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny <0 || nx < 0 || ny >= n || nx >=m || map[ny][nx] == 0){
                    continue;
                }
                if(visited[ny][nx] == -1){
                    visited[ny][nx] = visited[cy][cx] + 1;
                    q.offer(new int[]{ny,nx});
                }
                else if(visited[ny][nx] > visited[cy][cx] + 1){
                    visited[ny][nx] = visited[cy][cx] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        for (int i = 0; i < 104; i++) {
            for (int j = 0; j < 104; j++) {
                visited[i][j] = -1;
            }
        }
        map = maps;
        n = map.length;
        m = map[0].length;
    
        bfs(0,0);
        answer = visited[n-1][m-1];
        return answer;
    }
}