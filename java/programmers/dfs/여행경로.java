import java.util.*;

class Solution {
    
    static Map<String, PriorityQueue<String>> mp = new HashMap<>();
    
    static ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        
        for(String [] ticket : tickets){
            mp.computeIfAbsent(ticket[0],k-> new PriorityQueue<>())
                .offer(ticket[1]);
        }
        
        dfs("ICN");
    
        return list.stream().toArray(String[]::new);
    }
    
    static void dfs(String city){
        while (mp.containsKey(city) && !mp.get(city).isEmpty()) {
            String next = mp.get(city).poll();
            dfs(next);
        }
        list.add(0, city);
    }
}
