import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        Comparator.comparingInt((Integer a) -> -a)
    );
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(int i = 0; i<operations.length;i++){
            String [] operation = operations[i].split(" ");
            int value = Integer.parseInt(operation[1]);
            if(operation[0].equals("I")){
                minHeap.offer(value);
                maxHeap.offer(value);
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            else{
                if(value == -1){
                    while(!minHeap.isEmpty()){
                        int removeValue = minHeap.poll();
                        if(map.containsKey(removeValue)){
                            if(map.get(removeValue) == 1){
                                map.remove(removeValue);
                            }
                            else{
                                map.put(removeValue, map.get(removeValue) - 1);
                            }
                            break;
                        }
                    }
                }
                else{
                    while(!maxHeap.isEmpty()){
                        int removeValue = maxHeap.poll();
                        if(map.containsKey(removeValue)){
                            if(map.get(removeValue) == 1){
                                map.remove(removeValue);
                            }
                            else{
                                map.put(removeValue, map.get(removeValue) - 1);
                            }
                            break;
                        }
                    }
                }
            }
        }
        if(maxHeap.isEmpty() || minHeap.isEmpty()){
            return new int[]{0,0};
        }
        
        while(!maxHeap.isEmpty()){
            int value = maxHeap.poll();
            if(map.containsKey(value)){
                answer[0] = value;
                break;
            }
        }
        
        while(!minHeap.isEmpty()){
            int value = minHeap.poll();
            if(map.containsKey(value)){
                answer[1] = value;
                break;
            }
        }
        
        return answer;
    }
}
