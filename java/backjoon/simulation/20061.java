// https://www.acmicpc.net/problem/20061

import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] x = new int[2];
    static int [] y = new int[2];
    
    static int [][] board = new int[11][11];
    
    static int score = 0;
    static int totalCount = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            int t = fs.nextInt();
            y[0] = fs.nextInt();
            x[0] = fs.nextInt();
            if(t == 1){
                x[1] = x[0];
                y[1] = y[0];
            }
            else if (t== 2){
                x[1] = x[0] + 1;
                y[1] = y[0];
            }
            else{
                x[1] = x[0];
                y[1] = y[0] + 1;
            }
            
            moveDown();
            moveRight();
            addScore();
            removeGreenBlock();
            removeBlueBlock();
            // printGreen();
            // printBlue();
        }
        countGreen();
        countBlue();
        System.out.println(score + "\n" + totalCount);
    }
    
    static void moveDown(){
        int dist = 11;
        for(int i = 0; i<2;i++){
            dist = Math.min(dist, findDownMinDist(i));
        }
        for(int i = 0; i < 2; i++){
            board[y[i]+dist][x[i]] = 1;
        }
    }
    
    static int findDownMinDist(int idx){
        int cnt = 0;
        for(int i = y[idx] + 1; i< 10;i++){
            if(board[i][x[idx]] == 1){
                break;
            }
            cnt++;
        }
        return cnt;
    }
    
    static void moveRight(){
        int dist = 11;
        for(int i = 0; i<2;i++){
            dist = Math.min(dist, findRightMinDist(i));
        }
        for(int i = 0; i < 2; i++){
            board[y[i]][x[i]+dist] = 1;
        }
    }
    
    static int findRightMinDist(int idx){
        int cnt = 0;
        for(int i = x[idx] + 1; i< 10;i++){
            if(board[y[idx]][i] == 1){
                break;
            }
            cnt++;
        }
        return cnt;
    }
    
    static void addScore(){
        checkGreen();
        checkBlue();
    }
    
    static void checkGreen(){
        for(int i = 6;i<10;i++){
            int cnt = 0;
            for(int j = 0; j<4;j++){
                if(board[i][j] == 0){
                    break;
                }
                cnt++;
            }
            if(cnt == 4){
                score++;
                for(int j = 0; j<4;j++){
                    board[i][j] = 0;
                }
                for(int j = i; j>=4;j--){
                    for(int k = 0;k <4;k++){
                        board[j][k] = board[j-1][k];
                    }
                }
            }
        }
    }
    
    static void checkBlue(){
        for(int i = 6;i<10;i++){
            int cnt = 0;
            for(int j = 0; j<4;j++){
                if(board[j][i] == 0){
                    break;
                }
                cnt++;
            }
            if(cnt == 4){
                score++;
                for(int j = 0; j<4;j++){
                    board[j][i] = 0;
                }
                for(int j = i; j>=4;j--){
                    for(int k = 0;k <4;k++){
                        board[k][j] = board[k][j-1];
                    }
                }
            }
        }
    }
    
    static void removeGreenBlock(){
        for(int i = 0; i<2;i++){
            int cnt = 0;
            for(int j = 0; j<4;j++){
                if(board[5][j] == 1){
                    break;
                }
                cnt++;
            }
            if(cnt == 4){
                continue;
            }
            for(int j = 9;j>=4;j--){
                for(int k = 0;k<4;k++){
                    board[j][k] = board[j-1][k];
                }
            }
        }
    }
    
    static void removeBlueBlock(){
        for(int i = 0; i<2;i++){
            int cnt = 0;
            for(int j = 0; j<4;j++){
                if(board[j][5] == 1){
                    break;
                }
                cnt++;
            }
            if(cnt == 4){
                continue;
            }
            for(int j = 9;j>=4;j--){
                for(int k = 0;k<4;k++){
                    board[k][j] = board[k][j-1];
                }
            }
        }
    }
    
    static void countGreen(){
        for(int i = 6;i<10;i++){
            for(int j = 0;j<4;j++){
                if(board[i][j] == 1){
                    totalCount++;
                }
            }
        }
    }
    
    static void countBlue(){
        for(int i = 0;i<4;i++){
            for(int j = 6;j<10;j++){
                if(board[i][j] == 1){
                    totalCount++;
                }
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
    }
}
