import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int answer = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()){
            //System.out.println(left + " " + right + " " + s.substring(left,right+1));
            if(left == right){
                set.add(s.charAt(left));
                answer = Math.max(answer, set.size());
                right++;
                continue;
            }
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(s.charAt((right)));
                answer = Math.max(answer, set.size());
                right++;
            }
            //System.out.println(set.size());
        }
        return answer;
    }
}
