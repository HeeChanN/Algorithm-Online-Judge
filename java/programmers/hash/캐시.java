import java.util.*;

class Solution {
    
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LRUCache<String, Integer> cache = new LRUCache(cacheSize);
        for(String tmp : cities){
            String city = tmp.toUpperCase();
            if(cache.containsKey(city)){
                cache.put(city,1);
                answer++;
            }
            else{
                cache.put(city,1);
                answer += 5;
            }
        }
        
        return answer;
    }
    
    static class LRUCache<K,V> extends LinkedHashMap<K,V>{
        
        int limit;
        
        public LRUCache(int limit){
            super((int)Math.ceil(limit / 0.75) + 1, 0.75f, true);
            this.limit = limit;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > limit;
        }
    }
}
