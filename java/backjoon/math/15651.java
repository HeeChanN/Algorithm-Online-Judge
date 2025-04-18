import java.io.*;
import java.util.*;

class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+4];
    }
    
    static int n,m;
    static int [] arr;
    
    static void comb(int idx){
        if(idx == m){
            for(int i = 0; i<m;i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i<=n;i++){
            arr[idx] = i;
            comb(idx+1);
        }
    }
    
    public static void main(String[] args) throws Exception{
        input();
        
        comb(0);
        System.out.println(sb.toString());
    }
}