import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static long m;
    static int n;
    static long [] arr = new long[100004];
    
    public static void main(String[] args) throws Exception{
        m = fs.nextLong();
        n = fs.nextInt();
        
        long sum = 0;
        long maxVal = 0;
        
        for(int i = 0; i<n;i++){
            arr[i] = fs.nextLong();
            sum +=arr[i];
            maxVal = Math.max(arr[i], maxVal);
        }
        long base = sum - m;
        long l = 0;
        long r = maxVal;
        long best = maxVal;
        while(l<=r){
            long mid = l + ((r-l)/2);
            long s = 0;
            for(int i = 0; i<n;i++){
                if(mid < arr[i]){
                    s+= mid;
                }
                else{
                    s+=arr[i];
                }
            }
            
            if(s >= base){
                best = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        long t = best;

        long k = 0;
        long sumMin = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long x = arr[i];
            if (x < t) {
                ans += x * x;
                sumMin += x;
            } else {
                k++;
                sumMin += t;
            }
        }

        long E = sumMin - base;  
        ans += k * t * t;
        ans -= 2L * E * t;
        ans += E;

        System.out.println(Long.toUnsignedString(ans));
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
        
        long nextLong() throws Exception{
            return Long.parseLong(next());
        }
    }
}
