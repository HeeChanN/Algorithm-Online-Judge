import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        for(int i = 0; i<n;i++){
            String s = sc.next();
            if(isVPS(s)){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
    
    static boolean isVPS(String str){
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<str.length();i++){
            if(stack.size() == 0 && str.charAt(i) == ')'){
                return false;
            }
            if(str.charAt(i) == '('){
                stack.push(9);
            }
            else{
                stack.pop();
            }
        }
        if(stack.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    static class FastScanner{
        
    }
}
