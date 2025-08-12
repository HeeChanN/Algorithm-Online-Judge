// https://www.acmicpc.net/problem/15824
import java.util.*;
import java.io.*;


class Main {
    
    static FastScanner fs= new FastScanner();
    static int n;
    static int[] arr;
    
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextInt();
        }
        
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) 
            pow[i] = (pow[i - 1] * 2) % 1000000007;
        
        long sum = 0;
        Arrays.sort(arr);
        for(int i = 0; i<n;i++){
            long maxCnt = pow[i];
            long minCnt = pow[n-1-i];
            long total = (maxCnt - minCnt) % 1000000007;
            if (total < 0) {
                total += 1000000007;
            }
            
            long tmp = ((arr[i] % 1000000007) * total) % 1000000007;
            sum = (sum + tmp) % 1000000007;
        }
        System.out.print(sum);
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
