import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();
        if(s.length() == 1){
            return 1;
        }
        for(int i = 1; i<=s.length() / 2; i++){
            int left = i;
            int right = left + i;
            String alpha = s.substring(0,i);
            int cnt = 1;
            //System.out.println(i + " " + alpha);
            while(true){
                if(right > n){
                    if(cnt != 1){
                        sb.append(cnt);
                    }
                    sb.append(alpha);
                    if(left < n){
                        sb.append(s.substring(left));
                    }
                    break;
                }
                if(alpha.equals(s.substring(left,right))){
                    left = right;
                    right = right + i;
                    cnt++;
                }
                else{
                    if(cnt!=1){
                        sb.append(cnt);
                    }
                    sb.append(alpha);
                    cnt = 1;
                    if(right <= n){
                        alpha = s.substring(left,right);
                    }
                    left = right;
                    right = right + i;
                }
                //System.out.println(alpha + " " + left +  " " + right + " " + cnt);
                //System.out.println(sb);
            }
            //System.out.println(sb);
            answer = Math.min(answer, sb.length());
            sb.setLength(0);
        }
        return answer;
    }
    
    
}
