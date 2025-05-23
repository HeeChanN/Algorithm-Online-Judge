import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int[][] board = new int[20][20];
    static int[][] arr = new int[20][20];
    static ArrayList<Integer> archer = new ArrayList<>();
    static Queue<int[]> q = new ArrayDeque<>();
    static int n,m,d,num;
    static int ret = 0;
    
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        d = fs.nextInt();
    
        for(int i = 0; i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = fs.nextInt();
            }
        }
        
        comb(-1,0);
        System.out.print(ret);
    }
    
    static void comb(int start,int i){
        if(archer.size() == 3){
            ret = Math.max(ret, logic());
            return;
        }
        for(int idx = start+1;idx<=m-3+i;idx++){
            archer.add(idx);
            comb(idx,i+1);
            archer.remove(archer.size()-1);
        }
    }
    
    static int logic(){
        int removeCnt = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                board[i][j] = arr[i][j]; 
            }
        }
        
        while(true){
            for(int i = 0; i<3;i++){
                int ny = n;
                int nx = archer.get(i);
                findEnemy(ny,nx);
            }
            removeCnt += removeEnemy();
            moveEnemy();
            if(checkFinish()){
                break;
            }
        }
        return removeCnt;
    }
    
    static void findEnemy(int y, int x){
        int ty = -1;
        int tx = -1;
        int dist = 987654321;
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]==1){
                    int nextDist = Math.abs(y - i) + Math.abs(x-j);
                    if(nextDist <= d){
                        if(nextDist < dist){
                            dist = nextDist;
                            ty = i;
                            tx = j;
                        }
                        else if(nextDist == dist && j < tx){
                            ty = i;
                            tx = j;
                        }
                    }
                }
            }
        }
        if(dist != 987654321){
            q.offer(new int[]{ty,tx});
        }
    }
    
    static int removeEnemy(){
        int cnt = 0;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            if(board[y][x] == 1){
                cnt++;
                board[y][x] = 0;
            }
        }
        return cnt;
    }
    
    static void moveEnemy(){
        for(int i = n-1; i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(board[i][j] == 1){
                    board[i+1][j] = 1;
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static boolean checkFinish(){
        for(int i = 0; i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
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
