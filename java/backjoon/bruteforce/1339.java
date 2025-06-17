import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    
    static int n,s=0;
    static String[] codes;
    static ArrayList<Character> alphabet = new ArrayList<>();
    static ArrayList<Integer> v = new ArrayList<>();
    static int [] visited = new int[27];
    static int[] m = new int[27];
    static int ret = 0;
    
    public static void main(String[] args) throws Exception{
        init();
        comb();
        System.out.print(ret);
    }
    
    static void comb(){
        if(v.size() == alphabet.size()){
            matchNumber();
            addCodes();
            return;
        }
        for(int i = 0; i<alphabet.size();i++){
            if(visited[i] != 0){
                continue;
            }
            visited[i] = 1;
            v.add(i);
            comb();
            visited[i] = 0;
            v.remove(v.size() - 1);
        }
    }
    
    static void matchNumber(){
        int num = 9;
        
        for(int i = 0;i<v.size();i++){
            int idx = v.get(i);
            m[alphabet.get(idx) - 'A'] = num;
            num--;
        }
    }
    
    
    static void addCodes(){
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(String code : codes){
            for(int i = 0; i<code.length();i++){
                char ch = code.charAt(i);
                sb.append(m[ch-'A']);
            }
            sum += Integer.parseInt(sb.toString());
            sb.setLength(0);
        }
        ret = Math.max(ret, sum);
    }
    
    static void init() throws Exception{
        n = fs.nextInt();
        codes = new String[n];
        for(int i = 0 ;i<n;i++){
            codes[i] = fs.next();
            for(int j = 0;j<codes[i].length();j++){
                if(visited[codes[i].charAt(j) - 'A'] == 0){
                    visited[codes[i].charAt(j) - 'A'] = 1;
                    alphabet.add(codes[i].charAt(j));
                }
            }
        }
        Arrays.fill(visited,0);
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
