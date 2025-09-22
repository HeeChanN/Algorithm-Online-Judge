import java.util.*;

class Solution {
    
    static Map<String, String> mp = new HashMap<>();
    static ArrayList<String[]> chats = new ArrayList<>();
    
    public String[] solution(String[] record) {
        String[] answer;
        
        for(int i = 0; i<record.length;i++){
            String [] code = record[i].split(" ");
            if(code[0].equals("Enter")){
                mp.put(code[1], code[2]);
                chats.add(new String[]{code[1], "e"});
            }
            else if(code[0].equals("Leave")){
                chats.add(new String[]{code[1], "l"});
            }
            else{
                mp.put(code[1],code[2]);
            }
        }
        
        answer = new String[chats.size()];
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(String [] chat : chats){
            String nickname = mp.get(chat[0]);
            String act = chat[1].equals("e") ? "들어왔습니다." : "나갔습니다.";
            sb.append(nickname).append("님이 ").append(act);
            answer[idx++] = sb.toString();
            sb.setLength(0);
        }
    
        return answer;
    }
}
