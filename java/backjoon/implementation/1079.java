// https://www.acmicpc.net/problem/1079

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static int [] arr = new int[17];
    static int [][] board = new int[17][17];
    static int me;
    static int ret = 0;
    
    static int [] die = new int[17];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = fs.nextInt();
            }
        }
        me = fs.nextInt();
        
        //처음 홀 수 일 때
        if(n%2 == 1){
            int value = -27;
            int t = 19;
            for(int i = 0; i<n;i++){
                if(value < arr[i]){
                    value = arr[i];
                    t = i;
                }
            }
            die[t] = 1;
        }
        if(die[me] == 1){
            System.out.print(0);
        }
        // 홀수일 경우 시작 
        else{
            for(int i = 0; i<n;i++){
                if(i == me || die[i] == 1){
                    continue;
                }
                go(i,1);
            }
            System.out.print(ret);
        }
    }
    
    static void go(int target, int cnt){
        // System.out.print(target + " " + cnt + " : ");
        // print();
    
        // if(isFinish()){
        //     ret = cnt;
        //     return;
        // }
        // target 죽이고 arr 최신화
        die[target] = 1;
        for(int i = 0; i<n;i++){
            arr[i] += board[target][i];
        }
        // 낮에 죽이기
        int value = -27;
        int tt = 19;
        for(int i = 0; i<n;i++){
            if(die[i] == 0 && value < arr[i]){
                value = arr[i];
                tt = i;
            }
        }
        die[tt] = 1;
        
        if(die[me] == 1){
            ret = Math.max(ret, cnt);
            die[target] = 0;
            die[tt] = 0;
            for(int i = 0; i<n;i++){
                arr[i] -= board[target][i];
            }
            return;
        }
        
        for(int i = 0; i<n;i++){
            if(i == me || die[i] == 1){
                continue;
            }
            go(i,cnt+1);
        }
        die[target] = 0;
        die[tt] = 0;
        for(int i = 0; i<n;i++){
            arr[i] -= board[target][i];
        }
    }
    
    static void print(){
        for(int i = 0; i<n;i++){
            System.out.print(die[i] + " ");
        }
        System.out.println();
    }
    
    static boolean isFinish(){
        for(int i = 0; i<n;i++){
            if(i != me && die[i] == 0){
                return false;
            }
        }
        return true;
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
