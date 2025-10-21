import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();
    static int n;
    
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(fs.nextLine());
        
        while(n-->0){
            String str = fs.nextLine();
            int depth = 0;
            for(int i = 0; i<str.length();i++){
                if(stack.isEmpty()){
                    stack.push(1);
                }
                else if(str.charAt(i)=='['){
                    int top = stack.peek();
                    stack.push(top + 1);
 
                }
                else{ // "]"
                    int top = stack.pop();
                    depth = Math.max(depth, top);

                }
            }
            
            sb.append((int)Math.pow(2,depth)).append("\n");
            stack.clear();
        }
        System.out.print(sb);
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
        
        String nextLine() throws Exception {
            st = null;
            return br.readLine();
        }
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
