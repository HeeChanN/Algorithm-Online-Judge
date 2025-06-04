import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
 
    static int n;
    static int [] arr;
    static int ret = 1;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        arr = new int[n];
        
        for(int i = 0;i<n;i++){
            arr[i] = fs.nextInt();
        }
        
        Arrays.sort(arr);
        
        for(int i = 0;i<n;i++){
            int num = arr[i];
            int limit = ret;
            for(int j=0;j<limit;j++){
                if(j + num == ret){
                    ret++;
                }
            }
        }
        System.out.println(ret);
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
