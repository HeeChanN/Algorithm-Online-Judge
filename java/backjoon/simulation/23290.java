// https://www.acmicpc.net/problem/23290

import java.util.*;
import java.io.*;

class Main {
    
    static int [] dy = {0,-1,-1,-1,0,1,1,1};
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] sdy = {0,-1,0,1,0};
    static int [] sdx = {0,0,-1,0,1};
    
    static FastScanner fs = new FastScanner();
    static int[][][] board = new int[4][4][8];
    static int[][] block = new int[4][4];
    
    static int m,s;
    static int [] shark = new int[2];
    static int[][] best = new int[3][2];
    static int [][] visited = new int[4][4];
    static int ret = 0;
    static int order = 999;
    
    
    public static void main(String[] args) throws Exception{
        m = fs.nextInt();
        s = fs.nextInt();
        for(int i = 0; i<m;i++){
            int y = fs.nextInt();
            int x = fs.nextInt();
            int d = fs.nextInt();
            board[y-1][x-1][d-1]++;
        }
        
        shark[0] = fs.nextInt() - 1;
        shark[1] = fs.nextInt() - 1;
        
        for(int i = 0; i<s;i++){
            int [][][] copy = new int[4][4][8];
            // 1. 복제 마법
            copyBoard(copy);
            // print();
            // printCopy(copy);
            
            
            // 2. 물고기 이동
            int [][][] tmp = new int[4][4][8];
            for(int j = 0; j<4;j++){
                for(int k = 0; k<4;k++){
                    for(int l = 0; l<8;l++){
                        if(board[j][k][l] != 0){
                            moveFish(tmp, j,k,l);
                        }
                    }
                }
            }
            renewBoard(tmp);
            
            // 3. 상어 이동
            ArrayList<int[]> v = new ArrayList<>();
            resetPrevData();
            dfs(0,v,0,shark[0],shark[1]);
            shark[0] = best[2][0];
            shark[1] = best[2][1];
            
            // 4. 흔적 지우며 새로운 흔적 추가하기
            refreshBlock();
            removeFish();
            
            // 5. 복제 마법 실행
            for(int j = 0; j<4;j++){
                for(int k = 0; k<4;k++){
                    for(int l = 0; l<8;l++){
                        board[j][k][l] += copy[j][k][l];
                    }
                }
            }
            // print();
            // System.out.println(shark[0] + " " + shark[1]);
            // printBlock();
        }
        int answer = 0;
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                for(int k = 0; k<8;k++){
                    answer += board[i][j][k];
                }
            }
        }
        System.out.print(answer);
    }
    
    static void printBest(){
        for(int i = 0; i<3;i++){
            System.out.println(best[i][0]+" " + best[i][1]);
        }
    }
    
    static void printBlock(){
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void print(){
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                System.out.print("(y,x) " + i + " " + j + "| ");
                for(int k = 0; k<8;k++){
                    System.out.print(board[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------");
        }
        System.out.println();
    }
    
    static void printCopy(int[][][] copy){
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                System.out.print("(y,x) " + i + " " + j + "| ");
                for(int k = 0; k<8;k++){
                    System.out.print(copy[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------");
        }
        System.out.println();
    }
    
    static void refreshBlock(){
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                if(block[i][j] != 0){
                    block[i][j]--;
                }
            }
        }
        for(int i = 0; i<3;i++){
            int y = best[i][0];
            int x = best[i][1];
            for(int j = 0; j<8;j++){
                if(board[y][x][j] != 0){
                    block[y][x] = 2;
                    break;
                }
            }
        }
    }
    
    static void removeFish(){
        for(int i = 0; i<3;i++){
            int y = best[i][0];
            int x = best[i][1];
            for(int j = 0; j<8;j++){
                board[y][x][j] = 0;
            }
        }
    }
    
    static void dfs(int cnt, ArrayList<int[]> v, int sum, int y, int x){
        if(cnt == 3){
            if(sum > ret){
                ret = sum;
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<3;i++){
                    best[i][0] = v.get(i)[0];
                    best[i][1] = v.get(i)[1];
                    sb.append(v.get(i)[2]);
                }
                order = Integer.parseInt(sb.toString());
            }
            else if(sum == ret){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<3;i++){
                    sb.append(v.get(i)[2]);
                }
                int a = Integer.parseInt(sb.toString());
                if(a < order){
                    order = a;
                    for(int i = 0; i<3;i++){
                        best[i][0] = v.get(i)[0];
                        best[i][1] = v.get(i)[1];
                    }
                }
            }
            return;
        }
        for(int i = 1; i<=4;i++){
            int ny = y + sdy[i];
            int nx = x + sdx[i];
            if(ny < 0 || nx < 0 || ny >=4 || nx >=4){
                continue;
            }
            int a = 0;
            for(int j = 0;j<8;j++){
                a+= board[ny][nx][j];
            }
            v.add(new int[]{ny,nx,i});
            if(visited[ny][nx] != 0){
                a = 0;
            }
            visited[ny][nx]++;
            dfs(cnt + 1, v, sum + a, ny, nx);
            visited[ny][nx]--;
            v.remove(v.size() - 1);
        }
    }
    
    static void resetPrevData(){
        ret = -1;
        order = 999;
        for(int i = 0; i<3;i++){
            for(int j = 0;j<2;j++){
                best[i][j] = 0;
            }
        }
    }
    
    static void moveFish(int[][][] tmp, int y, int x, int d){
        int ny = y;
        int nx = x;
        int nd = d;
        while(true){
            ny = y + dy[nd];
            nx = x + dx[nd];
            if(ny < 0 || nx < 0 || ny >=4 || nx >= 4 || (shark[0] == ny && shark[1] == nx) || block[ny][nx] != 0){
                nd = (nd + 7) % 8;
                if(nd == d){
                    tmp[y][x][d] += board[y][x][d];
                    return;
                }
                continue;
            }
            // System.out.println(y + " " + x + " "+ d);
            // System.out.println(ny + " " + nx + " " + nd);
            tmp[ny][nx][nd] += board[y][x][d];
            return;
        }
    }
    
    static void renewBoard(int[][][] tmp){
        for(int i = 0;i<4;i++){
            for(int j = 0; j<4;j++){
                for(int k = 0;k<8;k++){
                    board[i][j][k] = tmp[i][j][k];
                }
            }
        }
    }
    
    static void copyBoard(int[][][] copy){
        for(int i = 0;i<4;i++){
            for(int j = 0; j<4;j++){
                for(int k = 0;k<8;k++){
                    copy[i][j][k] = board[i][j][k];
                }
            }
        }
    }
    
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
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
