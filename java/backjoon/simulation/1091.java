// https://www.acmicpc.net/problem/1091

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n;
    static int [] arr = new int[49];
    
    static Set<Integer> [] player = new HashSet[3];
    static int [] s = new int[49];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<3;i++){
            player[i] = new HashSet<>();
        }
        
        // 원하는 카드
        for(int i = 0; i<n;i++){
            int idx = fs.nextInt();
            player[idx].add(i);
            arr[i] = i;
        }
        
        // 카드 셔플마다 사용용
        for(int i = 0; i<n;i++){
            s[i] = fs.nextInt();
        }
        
        // 시뮬레이션 시작
        int cnt = 0;
        while(true){
            if(check()){
                break;
            }
            shuffle();
            cnt++;
            if(isImpossible()){
                cnt = -1;
                break;
            }
        }
        System.out.print(cnt);
    }
    
    static boolean isImpossible(){
        for(int i = 0; i<n;i++){
            if(arr[i] != i){
                return false;
            }
        }
        return true;
    }
    
    static boolean check(){
        for(int i = 0; i<n;i++){
            int idx = i%3;
            if(!player[idx].contains(arr[i])){
                return false;
            }
        }
        return true;
    }
    
    static void shuffle(){
        int [] tmp = new int[n+1];
        for(int i = 0; i<n;i++){
            int target = s[i];
            tmp[target] = arr[i];
        }
        
        for(int i = 0; i<n;i++){
            arr[i] = tmp[i];
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
