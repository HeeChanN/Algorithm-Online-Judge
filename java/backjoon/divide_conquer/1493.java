import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m,o;
    static int k;
    static int flag = 1;
    
    static int [] arr = new int[24];
    
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        m = fs.nextInt();
        o = fs.nextInt();
        
        k = fs.nextInt();
        for(int i =0 ;i <k;i++){
            int idx = fs.nextInt();
            arr[idx] = fs.nextInt();
        }
        int ret = go(n,m,o);
        if(flag == 0){
            System.out.print("-1");
        }
        else{
            System.out.print(ret);
        }
    }
    
    static int go(int l, int w, int h){
        if(flag == 0){
            return 0;
        }
        if(l == 0 || w == 0 || h == 0){
            return 0;
        }
        if(l == 1 && w == 1 && h == 1){
            if(arr[0] == 0){
                flag = 0;
                return 0;
            }
            else{
                arr[0]--;
                return 1;
            }
        }
        int v = Math.min(Math.min(l,w), h);
        int idx = selectBox(v);
        int len = (1<<idx);
        int up =0,left=0,right=0,edge=0;
        if(h-len != 0){
            up = go(l,w, h - len);
        }
        if(l-len != 0){
            left = go(l-len, len, len);
        }
        if(w-len != 0){
            right = go(len, w-len, len);
        }
        if(l-len != 0 && w - len != 0){
            edge = go(l-len, w-len, len);
        }
        return up + left + right + edge + 1;
    }
    
    static int selectBox(int v){
        int idx = -1;
        for(int i = 0;i<20;i++){
            if(v < (1 << i)){
                break;
            }
            if(arr[i] <=0){
                continue;
            }
            idx = i;
        }
        if(idx == -1){
            flag = 0;
            return 0;
        }
        arr[idx]--;
        return idx;
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st ==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
