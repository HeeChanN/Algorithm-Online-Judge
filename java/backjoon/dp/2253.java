import java.util.*;
import java.io.*;


class Main {
    
    static FastScanner fs = new FastScanner();
    static int [][] dp = new int[200][10004];
    static Set<Integer> no = new HashSet<>();
    static int n,m,tmp;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        m = fs.nextInt();
        
        for(int i = 0; i<m;i++){
            tmp = fs.nextInt();
            no.add(tmp);
        }
        for(int [] row : dp){
            Arrays.fill(row, 987654321);
        }
        int ret = go(1,2) + 1;
        if(ret > 987654321){
            System.out.print("-1");
        }
        else{
            System.out.print(ret);
        }
    }
    
    static int go(int prev, int idx){
        if(no.contains(idx) || idx > n){
            return 987654321;
        }
        if(idx == n){
            return dp[prev][idx] = 0;
        }
        if(dp[prev][idx] != 987654321){
            return dp[prev][idx];
        }
        int slow = (prev  == 1) ? 987654321 : go(prev-1,idx+prev-1) + 1;
        int same = go(prev, idx + prev)+1;
        int fast = go(prev+1, idx + prev +1) + 1;
        dp[prev][idx] = Math.min(slow, same);
        dp[prev][idx] = Math.min(dp[prev][idx], fast);
        return dp[prev][idx];
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
