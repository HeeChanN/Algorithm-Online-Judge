import java.util.*;
import java.io.*;
class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static long x;
    static long [][] info = new long[52][2];
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        x = fs.nextLong();

        info[0][0] = 1;
        info[0][1] = 1
        for (int i = 1; i <= n; i++) {
            info[i][0] = info[i-1][0] * 2 + 3;
            info[i][1] = info[i-1][1] * 2 + 1;
        }

        long cnt = 0;
        while (true) {
            if (n == 0) {
                if (x > 0) {
                    cnt += 1;
                }
                break;
            }
            if (n == 1 && x <= 5) {
                String first = "BPPPB";
                for (int i = 0; i < x; i++) if (first.charAt(i) == 'P') cnt++;
            break;
            }

            long len  = info[n][0];
            long pats = info[n][1];
            long half = len / 2;

            if (x <= half) {
                n = n - 1;
                x = Math.max(0, x - 1);
            } else {
                cnt += (pats - 1) / 2; 
                n = n - 1;
                x = x - half; 
                if (x > 0) {
                    cnt++;
                    x = Math.max(0, x - 1);
                }
            }
        }
        System.out.print(cnt);
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
