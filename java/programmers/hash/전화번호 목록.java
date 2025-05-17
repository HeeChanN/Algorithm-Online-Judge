import java.util.*;
import java.io.*;

class Solution {
    
    static Set<String> s = new HashSet<>();
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        for(String phone : phone_book){
            for(int i = 1; i<=phone.length();i++){
                String piece = phone.substring(0,i);
                if(s.contains(piece)){
                    answer = false;
                    break;
                }
            }
            if(answer == false){
                break;
            }
            s.add(phone);
        }
        
        return answer;
    }
}
