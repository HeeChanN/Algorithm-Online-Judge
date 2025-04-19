import java.util.*;

class Solution {
    
    static Map<String, Integer> mp = new HashMap<>(); 
    
    public int solution(String[][] clothes) {
        int answer = 0;
        int ret = 1;
        for(int i = 0; i<clothes.length; i++){
            mp.merge(clothes[i][1],1,Integer::sum);
        }
        for(Map.Entry<String,Integer> e: mp.entrySet()){
            ret = ret * (e.getValue() +1);
        }
        answer = ret - 1;
        return answer;
    }
}