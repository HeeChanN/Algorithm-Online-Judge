import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n;
    static int cnt = 0;
    
    static ArrayList<Integer> []small = new ArrayList[2];
    static ArrayList<Integer> []tall = new ArrayList[2];
    
    // 0 -> man, 1 -> women
    // small은 자기보다 작은 사람 <-> 여자는 큰사람을 원함
    // tall 은 자기보다 큰 사람 < - > 여자는 작은 사람을 원함
    public static void main(String[] args) throws Exception{
        
        n = fs.nextInt();
        for(int i = 0; i<2;i++){
            small[i] = new ArrayList<>();
            tall[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n;i++){
            int num = fs.nextInt();
            if(num < 0){
                small[0].add(Math.abs(num));
            }
            else{
                tall[0].add(num);
            }
        }
        
        for(int i = 0; i<n;i++){
            int num = fs.nextInt();
            if(num < 0){
                small[1].add(Math.abs(num));
            }
            else{
                tall[1].add(num);
            }
        }
        
        for(int i = 0; i<2;i++){
            Collections.sort(small[i]);
            Collections.sort(tall[i]);
        }
        
        int start = 0;
        // small[0]과 tall[1] 이어주기
        for(int i =0 ;i<small[0].size();i++){
            if(start >= tall[1].size()){
                break;
            }
            if(small[0].get(i) > tall[1].get(start)){
                start++;
                cnt++;
            }
        }
        
        start = 0;
        for(int i =0 ;i<small[1].size();i++){
            if(start >= tall[0].size()){
                break;
            }
            if(small[1].get(i) > tall[0].get(start)){
                start++;
                cnt++;
            }
        }
        System.out.print(cnt);
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
