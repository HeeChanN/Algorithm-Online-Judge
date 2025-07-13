import java.util.*;
import java.io.*;

class Main {
    
    static FastScanner fs = new FastScanner();
    static int n;
    static long ret = 0;
    static int [] building = new int[80004];
    
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        for(int i = 0; i<n;i++){
            building[i] = fs.nextInt();
        }
        for(int i = 0; i<n;i++){
            while(!stack.isEmpty() && stack.peek() <= building[i]){
                stack.pop();
            }
            ret += stack.size();
            stack.push(building[i]);
        }
        System.out.print(ret);
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
