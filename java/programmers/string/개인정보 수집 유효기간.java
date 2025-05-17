import java.util.*;

class Solution {
    
    static Map<String, Integer> mp = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        for(String term : terms){
            String [] a = term.split(" ");
            mp.put(a[0], Integer.parseInt(a[1]));
        }
        int i = 1;
        for(String privacy : privacies){
            String [] info = privacy.split(" ");
            String [] date = info[0].split("\\.");
            if(validateExpired(date, today,mp.get(info[1]))){
                list.add(i);
            };
            i++;
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    static boolean validateExpired(String[] date, String today, int limit){
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);
        m = m + limit;
        while(m>12){
            m = m - 12;
            y = y + 1;
        }
        d--;
        if(d == 0){
            m--;
            d=28;
        }
        if(m == 0){
            m=12;
            y--;
        }

        
        String [] tmp = today.split("\\.");
        int ay = Integer.parseInt(tmp[0]);
        int am = Integer.parseInt(tmp[1]);
        int ad = Integer.parseInt(tmp[2]);
        
        
        if(y < ay || (y == ay && m < am) || (y == ay && m == am && d < ad)){
            return true;
        }
        return false;
    }
}
