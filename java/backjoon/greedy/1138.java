import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int [] number;
    static ArrayList<Integer> arr = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        number = new int[n];
        for(int i = 0; i<n;i++){
            number[i] = fs.nextInt();
        }
        
        arr.add(n);
        for(int i = n-2;i>=0;i--){
            int idx = 0;
            int pos = number[i];
            while(pos > 0){
                pos--;
                idx++;
            }
            arr.add(idx, i+1);
        }
        for(int i = 0; i<arr.size();i++){
            sb.append(arr.get(i)).append(" ");
        }
        System.out.print(sb);
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
