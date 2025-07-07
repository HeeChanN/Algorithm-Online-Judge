import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,h;
    
    static int[] hol = new int[500001];
    static int[] jak = new int[500001];
    static int[] ret = new int[500001];
    static int num;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        h = fs.nextInt();
        
        for(int i = 0; i<n;i++){
            num = fs.nextInt();
            if(i % 2==0){
                jak[num]++;
            }
            else{
                hol[num]++;
            }
        }
        //석순 계산 (=jak)
        num = n /2;
        for(int i = 1; i<=h;i++){
            ret[i] = num;
            num = num - jak[i];
        }
        
        // 종유석 계산 (= hol)
        num = n/2;
        for(int i = 0;i<h;i++){
            ret[h-i] += num;
            num = num - hol[i+1];
        }
        
        int answer_min = 987654321;
        int answer_cnt = 0;
        
        for(int i = 1;i<=h;i++){
            if(ret[i] < answer_min){
                answer_cnt = 1;
                answer_min = ret[i];
            }
            else if (ret[i] == answer_min){
                answer_cnt++;
            }
        }
        System.out.print(answer_min + " "+ answer_cnt);
    }
    
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while (st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
