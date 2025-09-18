import java.util.*;

class Solution {
    
    static PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
        Comparator.comparingInt((ArrayList<Integer> a) -> a.size())
    );
    static boolean [] pick = new boolean[100004];
    static ArrayList<Integer> ret = new ArrayList<>();
    
    public int[] solution(String s) {
        int[] answer;
        
        int left = 1;
        int right = 1;
        while(left < s.length()-2){
            if(s.charAt(right) == '}'){
                changeStrToIntegerList(s, left+1, right);
                left = right+2;
                right = left;
            }
            else{
                right++;
            }
        }

        while(!pq.isEmpty()){
            ArrayList<Integer> tmp = pq.poll();
            
            for(int num : tmp){
                if(pick[num] == false){
                    ret.add(num);
                    pick[num] = true;
                }
            }
            System.out.println();
        }
        answer = new int[ret.size()];
        for(int i = 0;i<ret.size();i++){
            answer[i] = ret.get(i);
        }
        
        return answer;
    }
    
    static void changeStrToIntegerList(String s,int start, int end){
        ArrayList<Integer> arr = new ArrayList<>();
        String elem = s.substring(start,end);
        String [] numbers = elem.split(",");
        for(String number : numbers){
            arr.add(Integer.parseInt(number));
        }
        pq.offer(arr);
    }
}
