import java.util.*;

class Solution {
    
    static Map<String, Integer> A = new HashMap<>();
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        int sumA = 0;
        for(int i = 0; i<s1.length()-1;i++){
            if(isAlphabet(s1.charAt(i)) && isAlphabet(s1.charAt(i+1))){
                String tmp = s1.substring(i,i+2);
                int cnt = A.getOrDefault(tmp,0);
                A.put(tmp,cnt+1);
                sumA++;
            }
        }
        
        long inter = 0;
        long uni   = sumA; 
        
        Map<String,Integer> B = new HashMap<>();

        for (int i = 0; i < s2.length()-1; i++) {
            if (isAlphabet(s2.charAt(i)) && isAlphabet(s2.charAt(i+1))) {
                String key = s2.substring(i, i+2);
                int aCnt  = A.getOrDefault(key, 0);
                int bOld  = B.getOrDefault(key, 0);
                int bNew  = bOld + 1;
                B.put(key, bNew);
                
                inter += Math.min(aCnt, bNew) - Math.min(aCnt, bOld);
                uni   += Math.max(aCnt, bNew) - Math.max(aCnt, bOld);
            }
        
    
        }
        if(uni == 0){
            return 65536;
        }
        double result = (double)inter / uni;
        return (int) (result * 65536);
    }
            
    static boolean isAlphabet(char ch){
        if(('A' <= ch && ch <= 'Z')){
            return true;
        }
        return false;
    }
}
