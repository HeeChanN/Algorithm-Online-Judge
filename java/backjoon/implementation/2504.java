import java.util.*;
import java.io.*;

// stack으로 풀어보려하기
// 22,6
// 2 
// 3 * 3
// (2 + 9) * 2
// 3 * 2
class Main {
    
    static FastScanner fs = new FastScanner();
    static Deque<String> s = new ArrayDeque<>();
    static int flag =0;

    public static void main(String[] args) throws Exception{
       String str = fs.next();
       
       // 1. 열린 괄호는 일단 stack 처박기
       // 2. 닫힌 괄호는 숫자는 일단 빼고, 짝이 맞으면 연산 시작
       // 3. 닫힌 괄호인데 열린괄호가 없거나 짝이 안맞으면 그자리에서 break
       for(int i = 0; i<str.length();i++){
           char ch = str.charAt(i);
           
           if(ch == '(' || ch =='['){
               s.push(String.valueOf(ch));
               continue;
           }
           // 숫자 처리하기
           int num = 0;
           while(!s.isEmpty()){
               String top = s.peek();
               if(isBarket(top)){
                   break;
               }
               num += Integer.parseInt(top);
               s.poll();
           }
           
           // 괄호 짝 찾기
           String tmp = String.valueOf(ch);
           if(!isAvailable(String.valueOf(tmp))){
               flag = 1;
               break;
           }
           
            if(s.peek().equals("(") && tmp.equals(")")){
                s.pop();
                num = (num == 0) ? 2 : num * 2; 
            }
            else if(s.peek().equals("[") && tmp.equals("]")){
                s.pop();
                num = (num == 0) ? 3 : num * 3;
            }
            s.push(String.valueOf(num));
       }
       if(flag == 1){
           System.out.print(0);
       }
       else{
           int num = 0;
           while(!s.isEmpty()){
               String top = s.peek();
               if(isBarket(top)){
                   num = 0;
                   break;
               }
               num += Integer.parseInt(top);
               s.poll();
           }
          System.out.print(num);
       }
    }

    static boolean isBarket(String s){
        if(s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]")){
            return true;
        }
        return false;
    }
    
    static boolean isAvailable(String ch){
        if(s.isEmpty()){
            return false;
        }
        if(s.peek().equals("(") && ch.equals(")")){
            return true;
        }
        if(s.peek().equals("[") && ch.equals("]")){
            return true;
        }
        return false;
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
