import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static ArrayList<Integer> arr= new ArrayList<>();
    static Map<Integer,Integer> mp = new HashMap<>();
    
    static int n, L,R,X;
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        L = fs.nextInt();
        R = fs.nextInt();
        X = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            int k = fs.nextInt();
            arr.add(k);
        }
        
        go(0,0, 1000000000, -1);
        System.out.print(ret);
    }
    
    static void go(int idx, int sum, int minNum, int maxNum){
        if(idx == n){
            if(maxNum - minNum >= X && (sum >= L && sum <= R)){
                ret ++;
            }
            return;
        }
        go(idx + 1, sum + arr.get(idx),Math.min(minNum, arr.get(idx)), Math.max(maxNum, arr.get(idx)));
        go(idx+1, sum,minNum, maxNum);
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
