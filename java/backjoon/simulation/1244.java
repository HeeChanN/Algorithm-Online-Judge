import java.io.*;
import java.util.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int [] arr = new int[104];
    
    public static void main(String[] args) throws Exception{
        n =fs.nextInt();
        for(int i = 1; i<=n;i++){
            arr[i] = fs.nextInt();
        }
        m = fs.nextInt();
        for(int i = 0; i<m;i++){
            int gen = fs.nextInt();
            int idx = fs.nextInt();
            if(gen == 1){
                man(idx);
            }
            else{
                women(idx);
            }
            //print();
        }
        
        for(int i = 1; i<=n;i++){
            sb.append(arr[i]+" ");
            if(i%20 == 0){
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    
    static void man(int idx){
        for(int i = 1;i<=n;i++){
            if(i%idx == 0){
                arr[i] = (arr[i] +1)%2;
            }
        }
    }
    
    static void women(int idx){
        int left = idx-1;
        int right = idx+1;
        while(true){
            if(left == 0 || right == n+1){
                break;
            }
            if(arr[left] != arr[right]){
                break;
            }
            left--;
            right++;
        }
        // System.out.println(left + " " + right);
        for(int i = left + 1; i<right; i++){
            arr[i] = (arr[i] + 1) % 2;
        }
    }
    
    static void print(){
        for(int i = 1; i<=n;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
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
