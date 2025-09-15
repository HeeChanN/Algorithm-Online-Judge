import java.util.*;

class Solution {
    
    static String order;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> mp = new HashMap<>();
    static ArrayList<String> ret = new ArrayList<>();
    static Queue<String>[] rank = new ArrayDeque[11];
    
    public String[] solution(String[] orders, int[] course) {
        String [] answer;
        for(int i = 0; i<orders.length;i++){
            char [] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            order = new String(ch);
            for(int j = 0; j<course.length;j++){
                if(order.length() >= course[j]){
                    comb(-1,course[j]);
                }
            }
        }
        for(int i = 1; i<11;i++){
            rank[i] = new ArrayDeque<>();
        }
        
        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            String code = entry.getKey();
            int cnt = entry.getValue();
            //System.out.println(code + " " + cnt);
            if(cnt >= 2){
                int len = code.length();
                if(rank[len].isEmpty()){
                    rank[len].offer(code);
                }
                else{
                    String cur = rank[len].peek();
                    if(mp.get(cur) < cnt){
                        while(!rank[len].isEmpty()){
                            rank[len].poll();
                        }
                        rank[len].offer(code);
                    }
                    else if (mp.get(cur) == cnt){
                        rank[len].offer(code);
                    }
                }
            }
        }
        for(int i = 1;i<=10;i++){
            while(!rank[i].isEmpty()){
                ret.add(rank[i].poll());
            }
        }
        Collections.sort(ret);
        answer = new String[ret.size()];
        for(int i = 0; i<ret.size();i++){
            answer[i] = ret.get(i);
        }
        return answer;
    }
    
    static void comb(int start, int k){
        if(sb.length() == k){
            String code = sb.toString();
            if(mp.containsKey(code)){
                mp.put(code, mp.get(code) + 1);
            }
            else{
                mp.put(code,1);
            }
            return;
        }
        for(int i = start + 1; i< order.length() - k + sb.length()+1;i++){
            sb.append(order.charAt(i));
            comb(i,k);
            sb.deleteCharAt(sb.length() -1);
        }
        return;
    }
}
