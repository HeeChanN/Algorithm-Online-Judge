import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    
    public static void main(String[] args) throws Exception{
        int k = fs.nextInt();
        int p = fs.nextInt();
        int n = fs.nextInt();

        long realK = k;
        for(int i = 0; i<n;i++){
            realK = (realK * p) % 1000000007;
        }
        System.out.print(realK);
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
