import java.util.*;

class Solution {
    
    static Comparator<Info> comp = Comparator.comparing((Info i) -> i.upperHead)
        .thenComparingInt((Info i) -> i.number);
    static ArrayList<Info> arr = new ArrayList<>(); 
    
    
    public String[] solution(String[] files) {
        String[] answer;
        
        for(String file : files){
            int start = 0;
            int end = 0;
            for(int i = 0; i<file.length();i++){
                if(file.charAt(i) >='0' && file.charAt(i) <= '9'){
                    start = i;
                    break;
                }
            }
            for(int i = start+1;i<file.length();i++){
                if(file.charAt(i) <'0' || file.charAt(i) > '9'){
                    end = i;
                    break;
                }
            }
            if(end == 0){
                end = file.length();
            }
            String head = file.substring(0,start);
            String number = file.substring(start,end);
            String tail = file.substring(end);
            arr.add(new Info(head,number,tail));
        }
        
        arr.sort(comp);
        StringBuilder sb = new StringBuilder();
        
        answer = new String[arr.size()];
        int idx = 0;
        for(Info i : arr){
            sb.append(i.head).append(i.originNumber).append(i.tail);
            answer[idx] = sb.toString();
            sb.setLength(0);
            idx++;
        }

        return answer;
    }
    
    static class Info{
        String head;
        String upperHead;
        int number;
        String originNumber;
        String tail;
        
        public Info(String head, String number, String tail){
            this.head = head;
            this.upperHead = head.toUpperCase();
            this.number = Integer.parseInt(number);
            this.originNumber = number;
            this.tail = tail;
        }
    }
}
