import java.util.*;

class Solution {
    
    static int limit;
    static int t;
    static int cnt;
    static int [] arr;
    
    
    static void dfs(int value, int idx){
        if(idx == limit){
            if(value == t){
                cnt++;
            }
            return;
        }
        dfs(value + arr[idx],idx+1);
        dfs(value - arr[idx],idx+1);
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = numbers;
        t= target;
        limit = numbers.length;
        
        dfs(0,0);
        answer = cnt;
        return answer;
    }
}