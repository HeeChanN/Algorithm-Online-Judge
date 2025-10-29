class Solution {
    
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        // 1. m의 문자열 재조정
        StringBuilder target = new StringBuilder();
        for(int i = 0; i<m.length()-1;i++){
            char ch = m.charAt(i);
            if(canSharp(ch) && m.charAt(i+1) == '#'){
                target.append(Character.toLowerCase(ch));
                i++;
            } 
            else{
                target.append(ch);
            }
        }
        if(m.charAt(m.length()-1) != '#'){
            target.append(m.charAt(m.length()-1));
        }
        
        // 2. musicinfos 파싱 및 비교
        StringBuilder music = new StringBuilder();
        StringBuilder repeatMusic = new StringBuilder();
        int maxDuration = -1;
        for(int i = 0; i<musicinfos.length;i++){
            String [] input = musicinfos[i].split(",");
            music.setLength(0);
            repeatMusic.setLength(0);
            int shour = Integer.parseInt(input[0].substring(0,2));
            int smin = Integer.parseInt(input[0].substring(3));
            int ehour = Integer.parseInt(input[1].substring(0,2));
            int emin = Integer.parseInt(input[1].substring(3));
            int duration =(ehour * 60 + emin) -  (shour * 60 + smin);
            if(duration == 0){
                continue;
            }
            
            String tmp = input[3];
            for(int j = 0; j<tmp.length()-1;j++){
                char ch = tmp.charAt(j);
                if(canSharp(ch) && tmp.charAt(j+1) == '#'){
                    music.append(Character.toLowerCase(ch));
                    j++;
                } 
                else{
                    music.append(ch);
                }
            }
            if(tmp.charAt(tmp.length()-1) != '#'){
                music.append(tmp.charAt(tmp.length()-1));
            }
            
            int len = music.length(); // 먼저 #을 제거하고 그리고 duration 만큼 반복
            for(int j = 0; j<duration;j++){
                repeatMusic.append(music.charAt(j%len));
            }
            
            String t = target.toString();
            String src = repeatMusic.toString();
            if(src.contains(t) && maxDuration < duration){
                maxDuration = duration;
                answer = input[2];
            }
        }
    
        return answer;
    }
    
    static boolean canSharp(char ch){
        if(ch == 'C' || ch == 'D' || ch == 'F' || ch == 'G' || ch == 'A' || ch =='E' || ch == 'B'){
            return true;
        }
        return false;
    }
}
