import java.util.*;
import java.io.*;

//1013
//976543210

// 1010
// 98765431

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int cnt = 10;
    static long ret = -1;
    
    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        if(0<=n && n<=9){
           ret = n;
        }
        else{
            int idx = 2;
            while(true){
                // 종료 조건
                if(idx == 10){
                    if(cnt == n){
                        ret = 9876543210L;
                    }
                    break;
                }
                go(idx,10);
                if(ret != -1){
                    break;
                }
                idx++;
            }
        }
        System.out.print(ret);
    }
    
    static void go(int idx, int start){
        if(idx == 0){
            int a = Integer.parseInt(sb.toString());
            if(cnt == n){
                ret = a;
            }
            cnt++;
            return;
        }
        for(int i = 0; i<start;i++){
            sb.append(i);
            go(idx-1,i);
            sb.deleteCharAt(sb.length()-1);
        }
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
