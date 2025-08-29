// https://www.acmicpc.net/problem/2933

import java.util.*;
import java.io.*;

class Main {
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m,t;
    static String str;
    static int[][] board = new int[104][104];
    static int removeIdx;
    static int v = 1;
    static int[][] area = new int[104][104];
    static int[] low = new int[2];
    static int isStable = 1;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        for(int i = 0; i<n;i++){
            str = fs.next();
            for(int j = 0; j<m;j++){
                if(str.charAt(j) == '.'){
                    board[i][j] = 0;
                }
                else{
                    board[i][j] = 1;
                }
            }
        }
        t = fs.nextInt();
        
        for(int i = 0; i<t;i++){
            resetArea();
            int row = fs.nextInt();
            row = n - row;
            if(i%2==0){
                removeIdx = removeFirstLeftMineral(row);
            }
            else{
                removeIdx = removeFirstRightMineral(row);
            }
            if(removeIdx == -1){
                continue;
            }

            v = 1;
            isStable = 1;
            for(int j = 0; j<4;j++){
                int ny = row + dy[j];
                int nx = removeIdx + dx[j];
                if(ny < 0 || nx < 0 || ny >= n || nx >=m){
                    continue;
                }
                if(area[ny][nx] == 0 && board[ny][nx] == 1){
                    bfs(ny,nx);
                    if(isStable == 0){
                        break;
                    }
                    v++;
                }
            }

            if(isStable == 1){
                continue;
            }

        
            int dist = findLowDist();
            moveMineral(dist);
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(board[i][j] == 0){
                    sb.append('.');
                }
                else{
                    sb.append("x");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static int findLowDist(){
        int num = 987654321;
        for(int i = n-1; i>=0;i--){
            for(int j = 0; j<m;j++){
                if(area[i][j] == v){
                   int dist = 0;
                   int y = i;

                   while(true){
                       y = y +1;
                       if(y != n && area[y][j] == v){
                           dist=987654321;
                       }
                       if(y >= n || board[y][j] == 1){
                           break;
                       }
                       dist++;
                   }
                   num = Math.min(num, dist);
                }
            }
        }
        return num;
    }
    
    
    static void moveMineral(int dist){
        for(int i = n-1; i>=0;i--){
            for(int j = 0; j<m;j++){
                if(area[i][j] == v){
                    board[i+dist][j] = 1;
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        area[y][x] = v;
        int flag = 1;
        while(!q.isEmpty()){
            int []cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            for(int i = 0; i<4;i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx <0 || ny>=n || nx >= m || board[ny][nx] == 0){
                    continue;
                }
                if(area[ny][nx] == 0){
                    q.offer(new int[]{ny,nx});
                    area[ny][nx] = v;
                    if(ny == n-1){
                        flag =0;
                    }
                }
            }
        }
        if(flag == 1){
            isStable = 0;
            return ;
        }
    }
    
    static int removeFirstLeftMineral(int row){
        for(int i = 0; i<m;i++){
            if(board[row][i] == 1){
                board[row][i] = 0;
                return i;
            }
        }
        return -1;
    }
    
    static int removeFirstRightMineral(int row){
        for(int i = m-1; i>=0;i--){
            if(board[row][i] == 1){
                board[row][i] = 0;
                return i;
            }
        }
        return -1;
    }
    
    static void resetArea(){
        for(int [] arr : area){
            Arrays.fill(arr,0);
        }
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void printArea(){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
