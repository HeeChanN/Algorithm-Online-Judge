import java.util.*;

class Solution {
    
    static Map<String, Integer> parking = new HashMap<>();
    static Map<String, Integer> use = new HashMap<>();
    static Set<String> cars = new HashSet<>();
    
    
    //List<Integer> list = new ArrayList<>(set);
    // Collections.sort(list);
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        simulate(records);
        calcRemain();
        
        List<String> list = new ArrayList<>(cars);
        Collections.sort(list);
        
        answer = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            int useTime = use.get(list.get(i));
            if(useTime <= fees[0]){
                answer[i] = fees[1];
            }
            else{
                useTime = useTime - fees[0];
                int over = useTime % fees[2] == 0 ? 0 : 1; 
                answer[i] = fees[1] + (useTime / fees[2] + over) * fees[3];
            }
        }
        
        return answer;
    }
    
    static void calcRemain(){
        int lastTime = 23 * 60 + 59;
        for(String car : cars){
            int time = parking.get(car);
            if(time == -1){
                continue;
            }
            int useTime = lastTime - time;
            if(use.containsKey(car)){
                int prev = use.get(car);
                use.put(car,prev + useTime);
            }
            else{
                use.put(car, useTime);
            }
        }
    }
    
    static void simulate(String [] records){
        
        for(int i = 0; i<records.length;i++){
            String [] info = records[i].split(" ");
            int min = calcMin(info[0]);
            if(info[2].equals("IN")){
                parking.put(info[1],min);
                cars.add(info[1]);
            }
            else{
                int startTime = parking.get(info[1]);
                int useTime = min - startTime;
                if(use.containsKey(info[1])){
                    int prev = use.get(info[1]);
                    use.put(info[1],prev + useTime);
                }
                else{
                    use.put(info[1], useTime);
                }
                parking.put(info[1], -1);
            }
        }
    }
    
    static int calcMin(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3));
        return hour * 60 + min;
    }
}
