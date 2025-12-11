import java.util.*;

// 일정한 금액 지불 -> 10일 동안 회원 자격을 부여
// 회원을 대상으로 매일 한 가지 제품을 할인하는 행사
// 할인하는 제품 -> 하나씩만 구매 가능
// 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 맞춰서 회원가입/ 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 맞춰서 회원가입


// 첫날부터 n번째 날까지 want의 길이만큼 충분한지 체크하고 충분하면 cnt++
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> match = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
           
        for(int i = 0; i<want.length;i++){
            if(map.containsKey(want[i])){
               map.put(want[i], map.get(want[i]) + number[i]);
            }
            else{
                map.put(want[i], number[i]);
            }
        }
        
        // 무조건 10개 봐야함
        // 처음에 그래서 0부터 9까지 미리 hashmap에 담아놓고 그 시점에 가능한지 파악
        // 이후 왼쪽 제거 오른쪽 추가로 반복
        for(int i = 0; i<10;i++){
            if(match.containsKey(discount[i])){
               match.put(discount[i], match.get(discount[i]) + 1);
            }
            else{
                match.put(discount[i], 1);
            }
        }
        if(isPossible()){
            answer++;
        }
        for(int i = 10; i< discount.length;i++){
            //printMatch();
            // 1. 왼쪽 제거, 오른쪽 추가
            int cnt = match.get(discount[i-10]) - 1;
            if(cnt == 0){
                match.remove(discount[i-10]);
            }
            else{
                match.put(discount[i-10], cnt);
            }
            if(match.containsKey(discount[i])){
                match.put(discount[i], match.get(discount[i]) + 1);
            }
            else{
                match.put(discount[i], 1);
            }
            
            // 2. 가능한지 검증
            if(isPossible()){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void printMatch(){
        for(Map.Entry<String, Integer> e : match.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println();
    }
    
    static boolean isPossible(){
        for(Map.Entry<String, Integer> e : match.entrySet()){
            String key = e.getKey();
            Integer cnt = e.getValue();
            if(!map.containsKey(key)){
                return false;
            }
            if(!map.get(key).equals(cnt)){
                return false;
            }
        }
        return true;
    }
}
