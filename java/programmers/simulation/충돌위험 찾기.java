import java.util.*;

class Solution {
    
    static Map<Pair,Integer> mp = new HashMap<>();
    
    // point 0~n-1
    // route 1~n
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        
        for(int i = 0; i<routes.length;i++){
            int t = 0;
            int flag = 0;
            for(int k = 1; k<routes[i].length;k++){
                int s = routes[i][k-1]-1;
                int e = routes[i][k]-1;
                int [] start = new int[]{points[s][0], points[s][1]};
                int [] end = new int[]{points[e][0], points[e][1]};
                if(start[0] > end[0]){
                    if(flag != 0){
                        start[0] = start[0] - 1;
                    }
                    flag = 1;
                    for(int j = start[0]; j>=end[0]; j--){
                        Pair p = new Pair(j,start[1],t);
                        if(!mp.containsKey(p)){
                            mp.put(p,1);
                        }
                        else if(mp.get(p) == 1){
                            answer++;
                            mp.put(p,2);
                        }
                        t++;
                    }
                    start[0] = end[0];
                }
                else if (start[0] < end[0]){
                    if(flag != 0){
                        start[0] = start[0] + 1;
                    }
                    flag = 1;
                    for(int j = start[0]; j<=end[0]; j++){
                        Pair p = new Pair(j,start[1],t);
                        if(!mp.containsKey(p)){
                            mp.put(p,1);
                        }
                        else if(mp.get(p) == 1){
                            answer++;
                            mp.put(p,2);
                        }
                        t++;
                    }
                    start[0] = end[0];
                }
                if(start[1] > end[1]){
                    if(flag != 0){
                        start[1] = start[1] - 1;
                    }
                    flag = 1;
                    for(int j = start[1]; j>=end[1]; j--){
                        Pair p = new Pair(start[0],j,t);
                        if(!mp.containsKey(p)){
                            mp.put(p,1);
                        }
                        else if(mp.get(p) == 1){
                            answer++;
                            mp.put(p,2);
                        }
                        t++;
                    }
                    start[1] = end[1];
                }
                else if (start[1] < end[1]){
                    if(flag != 0){
                        start[1] = start[1] + 1;
                    }
                    flag = 1;
                    for(int j = start[1]; j<=end[1]; j++){
                        Pair p = new Pair(start[0],j,t);
                        if(!mp.containsKey(p)){
                            mp.put(p,1);
                        }
                        else if(mp.get(p) == 1){
                            answer++;
                            mp.put(p,2);
                        }
                        t++;
                    }
                    start[1] = end[1];
                }
            }
        }
        return answer;
    }
    
    static class Pair{
        int y;
        int x;
        int t;
        
        public Pair(int y, int x, int t){
            this.y = y;
            this.x = x;
            this.t = t;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(!(o instanceof Pair)){
                return false;
            }
            Pair p = (Pair) o;
            return (y == p.y && x == p.x && t == p.t);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(y,x,t);
        }
        
        @Override
        public String toString(){
            return "{" + y + " " + x + " " + t + "}";
        }
    }
}
