// https://www.acmicpc.net/problem/9177

import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static String a,b,c;
    
    static int[] abCnt = new int [200];
    static int[] cCnt = new int[200];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            Arrays.fill(abCnt, 0);
            Arrays.fill(cCnt, 0);
            a = fs.next();
            b = fs.next();
            c = fs.next();
            if(!checkCnt()){
                sb.append("Data set ")
                .append(i+1).append(": no\n");
                continue;
            }
            if(validate(a) && validate(b)){
                sb.append("Data set ")
                .append(i+1).append(": yes\n");
            }
            else{
                sb.append("Data set ")
                .append(i+1).append(": no\n");
            }
        }
        System.out.print(sb);
    }
    
    static boolean validate(String target){
        int idx = 0;
        int move = 0;
        while(true){
            if(idx == target.length()){
                return true;
            }
            if(move == c.length()){
                return false;
            }
            if(target.charAt(idx) == c.charAt(move)){
                idx++;
            }
            move++;
        }
    }
    
    static boolean checkCnt(){
        for(int i = 0;i<a.length();i++){
            abCnt[a.charAt(i) - 'A']++;
        }
        for(int i = 0;i<b.length();i++){
            abCnt[b.charAt(i) - 'A']++;
        }
        for(int i = 0;i<c.length();i++){
            cCnt[c.charAt(i) - 'A']++;
        }
        for(int i = 0;i<100;i++){
            if(abCnt[i] != cCnt[i]){
                return false;
            }
        }
        return true;
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
