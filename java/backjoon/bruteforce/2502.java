import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int a,b;
    
    public static void main(String[] args) throws Exception {
        int d = fs.nextInt();
        int k = fs.nextInt();
        int pm = 0, pn = 1; 
        int m=1, n=1;
        
        for(int i = 3;i<=d;i++){
            int tmpM = m;
            int tmpN = n;
            m = m + pm;
            n = n + pn;
            pm = tmpM;
            pn = tmpN;
        }

        for(int i = 1; i<=500000;i++){
            a = pm * i;
            if((k - a) % pn  == 0){
                b = (k - a) / pn;
                a = i;
                break;
            }
        }
        System.out.print(a+"\n"+b);
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
    }
}
