import java.util.*;

class Solution {
    
    // 1000 * 1000 = 100만
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 27;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<26;i++){
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        int i = 0;
        while(i < msg.length()){
            for(int j = i+1; j<=msg.length();j++){
                String target = msg.substring(i,j);
                //System.out.println(target);
                if(!map.containsKey(target)){
                    map.put(target, idx++);
                    arr.add(map.get(msg.substring(i,j-1)));
                    i = j-1;
                    break;
                }
                if(j == msg.length()){
                    arr.add(map.get(msg.substring(i,j)));
                    i = j;
                }
            }
            //System.out.println();
        }
        answer = new int[arr.size()];
        
        for(int k = 0; k<arr.size();k++){
            answer[k] = arr.get(k);
        }
        return answer;
    }
}
