import java.util.*;
import java.io.*;

class Solution {
    
    static Map<String, Integer> mp1 = new HashMap<>();
    static Map<String ,PriorityQueue<int[]>> mp2 = new HashMap<>();
    static List<Pair> l = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    
    
    public int[] solution(String[] genres, int[] plays) {
    
        Comparator<int[]> comp = Comparator
            .comparingInt((int []a) -> a[0]).reversed()
            .thenComparingInt(a->a[1]);
        
        for(int i = 0; i<genres.length;i++){
            mp1.put(genres[i], mp1.getOrDefault(genres[i], 0) + plays[i]);
            mp2.computeIfAbsent(genres[i], k-> new PriorityQueue<>(comp))
                .offer(new int[]{plays[i],i});
        }
        
        for(Map.Entry<String, Integer> e : mp1.entrySet()){
            l.add(new Pair(e.getValue(), e.getKey()));
        }
        
        l.sort(Comparator.comparingInt((Pair p) -> p.cnt).reversed());
        
        for(Pair p : l){
            PriorityQueue<int[]> pq = mp2.get(p.name);
            int cnt = 0;
            while(!pq.isEmpty()){
                int [] pos = pq.poll();
                answer.add(pos[1]);
                cnt++;
                if(cnt == 2){
                    break;
                }
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    static class Pair{
        public int cnt;
        public String name;
        
        public Pair(int cnt, String name){
            this.cnt = cnt;
            this.name = name;
        }
    }
}
