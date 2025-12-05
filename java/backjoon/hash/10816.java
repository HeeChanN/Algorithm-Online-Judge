import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,m;
    static int [] arr = new int[20000004];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            int num = fs.nextInt() + 10000000;
            arr[num]++;
        }
        m = fs.nextInt();
        for(int i = 0; i<m;i++){
            int num = fs.nextInt()+10000000;
            sb.append(arr[num] + " ");
        }
        System.out.print(sb);
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
