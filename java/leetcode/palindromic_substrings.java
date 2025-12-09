import java.util.*;

class Solution {
    public int countSubstrings(String s) {
        int [][] dp = new int[1004][1004];
        int cnt = 0;
        for(int i = 0; i<s.length();i++){
            dp[i][i] = 1;
            cnt++;
        }
        for(int i = 0; i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i+1] = 1;
                cnt++;
            }
        }
        for(int len = 3; len<=s.length();len++){
            for(int i = 0; i<= s.length() - len;i++){
                int left = i;
                int right = i + len - 1;
                if(s.charAt(left) == s.charAt(right) && dp[left+1][right-1] == 1){
                    dp[left][right] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
