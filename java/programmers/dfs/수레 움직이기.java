// https://school.programmers.co.kr/learn/courses/30/lessons/250134
import java.util.*;

class Solution {
    
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    
    static int[][] red = new int[4][4];
    static int[][] blue = new int[4][4];
    
    static int [] sr;
    static int [] er;
    static int [] sb;
    static int [] eb;
    
    static int [][] board;
    
    static int n,m;
    static int answer = 987654321;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        board = new int[maze.length][maze[0].length];
        
        for(int i = 0; i<maze.length;i++){
            for(int j = 0; j<maze[i].length;j++){
                if(maze[i][j] == 1){
                    sr = new int[]{i,j};
                }
                else if(maze[i][j] == 2){
                    sb = new int[]{i,j};
                }
                else if(maze[i][j] == 3){
                    er = new int[]{i,j};
                }
                else if (maze[i][j] == 4){
                    eb = new int[]{i,j};
                }
                board[i][j] = maze[i][j];
            }
        }
        red[sr[0]][sr[1]] = 1;
        blue[sb[0]][sb[1]] = 1;
        dfs(sr[0], sr[1], sb[0], sb[1]);
        
        return answer == 987654321 ? 0 : answer - 1;
    }
    
    static void dfs(int ry, int rx, int by, int bx){
        if(ry == er[0] && rx == er[1] && by == eb[0] && bx == eb[1]){
            int tmp = Math.max(red[ry][rx], blue[by][bx]);
            answer = Math.min(tmp, answer);
            return;
        }
        int rflag = 0;
        for(int i = 0; i<4;i++){
            int nry, nrx;
            if(ry == er[0] && rx == er[1]){
                rflag = 1;
                nry = ry;
                nrx = rx;
            }
            else{
                nry = ry + dy[i];
                nrx = rx + dx[i];
            }
            int bflag = 0;
            for(int j = 0; j<4;j++){
                int nby, nbx;
                if(by == eb[0] && bx == eb[1]){
                    bflag = 1;
                    nby = by;
                    nbx = bx;
                }
                else{
                    nby = by + dy[j];
                    nbx = bx + dx[j];
                }
                
                if(nry < 0 || nrx < 0 || nby < 0 || nbx < 0 || nry >= n || nrx >=m || nby >= n || nbx >= m ||
                   board[nry][nrx] == 5 || board[nby][nbx] == 5){
                    continue;
                }
                if((nry == by && nrx == bx) && (nby == ry && nbx == rx)){
                    continue;
                }
                if(nry == nby && nrx == nbx){
                    continue;
                }
                if((rflag == 0 && red[nry][nrx] != 0) || (bflag == 0 && blue[nby][nbx] != 0)){
                    continue;
                }
                if(rflag == 0){
                    red[nry][nrx] = red[ry][rx] + 1;
                }
                if(bflag == 0){
                    blue[nby][nbx] = blue[by][bx] + 1;
                }
                dfs(nry,nrx,nby,nbx);
                if(rflag == 0){
                    red[nry][nrx] = 0;
                }
                if(bflag == 0){
                    blue[nby][nbx] = 0;
                }
            }
        }
        return ;
    }
}
