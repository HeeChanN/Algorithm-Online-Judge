import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();

        for (char c : number.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        if (k > 0) stack.setLength(stack.length() - k);

        return stack.toString();
    }
}