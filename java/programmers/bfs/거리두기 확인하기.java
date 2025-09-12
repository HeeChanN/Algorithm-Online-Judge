import java.util.*;
import java.io.*;

class Solution {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int[][] board = new int[5][5];
    static int[][] visited = new int[5][5];
    static int flag = 0;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i<5;i++){
            for(int j = 0; j<5;j++){
                for(int k = 0; k<5;k++){
                    if(places[i][j].charAt(k) == 'P'){
                        board[j][k] = 1;
                    }
                    else if(places[i][j].charAt(k) == 'O'){
                        board[j][k] = 0;
                    }
                    else{
                        board[j][k] = 2;
                    }
                }
            }
            
            for(int j = 0; j<5;j++){
                for(int k = 0; k<5;k++){
                    if(board[j][k] == 1){
                        bfs(j,k);
                        for(int [] row : visited){
                            Arrays.fill(row, 0);
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
                if(flag == 1){
                    break;
                }
            }
            
            if(flag == 1){
                answer[i] = 0;
            }
            else{
                answer[i] = 1;
            }
            flag = 0;
        }
        
        return answer;
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,0});
        visited[y][x] = 1;
        
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int py = pos[0];
            int px = pos[1];
            int cnt = pos[2];
            if(cnt == 2){
                continue;
            }
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny >=5 || nx >=5 || board[ny][nx] == 2 || visited[ny][nx] == 1){
                    continue;
                }
                if(board[ny][nx] == 1){
                    flag = 1;
                    return ;
                }
                q.offer(new int[]{ny,nx,cnt+1});
            }
        }
    }
}
