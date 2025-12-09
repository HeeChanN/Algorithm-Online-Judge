import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        
        String answer = String.valueOf(s.charAt(0));
        for(int len = 1; len<=s.length(); len++){
            for(int i = 0; i<=s.length()-len;i++){
                if(isPalindrom(i, i+len, s)){
                    answer = s.substring(i,i+len);
                    break;
                }
            }
        }
        return answer;
    }

    static boolean isPalindrom(int start, int end, String str){
        int left = start;
        int right = end-1;;
        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
