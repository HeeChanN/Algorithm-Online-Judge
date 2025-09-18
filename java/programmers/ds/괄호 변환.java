import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = go(p);
        return answer;
    }
    
    static String go(String s){
        if(s.equals("")){
            return "";
        }
        int lcnt = 0;
        int rcnt = 0;
        int idx = 1;
        if(s.charAt(0) == '('){
            lcnt++;
        }
        else{
            rcnt++;
        }
        for(; idx<s.length();idx++){
            if(s.charAt(idx) == ')'){
                rcnt++;
            }
            else{
                lcnt++;
            }
            if(lcnt == rcnt){
                break;
            }
        }
        
        String u = s.substring(0,idx+1);
        String v = s.substring(idx+1);
        System.out.println(u + " " + v);
        if(check(u)){
            v = go(v);
            return u + v;
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            v = go(v);
            sb.append(v);
            sb.append(")");
            System.out.println(sb);
            int left = 1;
            int right = u.length()-2;
            for(int i = left; i<=right;i++){
                if(u.charAt(i) == '('){
                    sb.append(")");
                }
                else{
                    sb.append("(");
                }
            }
            return sb.toString();
        }
    }
    
    static boolean check(String s){
        Deque<Integer> stack = new ArrayDeque<>();
        int flag = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '(' ){
                stack.push(1);
            }
            else{
                if(stack.isEmpty()){
                    flag = 1;
                    break;
                }
                stack.pop();
            }
        }
        if(flag == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
