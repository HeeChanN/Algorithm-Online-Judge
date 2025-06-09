import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder v = new StringBuilder();
    static int l,c;
    static String [] str;
    
    public static void main(String[] args) throws Exception {
        init();
        comb(-1);
        System.out.print(sb);
    }
    
    static void comb(int start){
        if(v.length() == l){
            logic();
            return;
        }
        for(int i = start + 1; i<c;i++){
            v.append(str[i]);
            comb(i);
            v.deleteCharAt(v.length() - 1);
        }
    }
    
    static void logic(){
        int cnt = 0;
        int cnt2 = 0;
        for(int i = 0; i<v.length();i++){
            char ch = v.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt++;
            }
            else{
                cnt2++;
            }
        }
        if(cnt >= 1 && cnt2 >=2){
            sb.append(v).append("\n");
        }
    }
    
    static void init() throws Exception{
        l = fs.nextInt();
        c = fs.nextInt();
        str = new String[c];
        String s;
        for(int i = 0; i<c;i++){
            s = fs.next();
            str[i] = s;
        }
        Arrays.sort(str);
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
