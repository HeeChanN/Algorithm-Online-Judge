import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> match = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
           
        for(int i = 0; i<want.length;i++){  
            map.put(want[i], map.getOrDefault(want[i], 0) + number[i]);
        }
        
        for(int i = 0; i<10;i++){
            match.put(discount[i], match.getOrDefault(discount[i], 0) + 1);
        }
        if(map.equals(match)){
            answer++;
        }
        for(int i = 10; i< discount.length;i++){
            int cnt = match.get(discount[i-10]) - 1;
            if(cnt == 0){
                match.remove(discount[i-10]);
            }
            else{
                match.put(discount[i-10], cnt);
            }
            if(match.containsKey(discount[i])){
                match.put(discount[i], match.get(discount[i]) + 1);
            }
            else{
                match.put(discount[i], 1);
            }
            
            if(map.equals(match)){
                answer++;
            }
        }
        
        
        return answer;
    }
}
