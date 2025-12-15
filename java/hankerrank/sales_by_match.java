import java.util.*;

class Result {
    public static int sockMerchant(int n, List<Integer> ar) {
        int ret = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int i = 0; i<ar.size();i++){
            counter.put(ar.get(i), counter.getOrDefault(ar.get(i), 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e : counter.entrySet()){
            int value = e.getValue();
            ret += value/2;
        }
        return ret;
    }

}
