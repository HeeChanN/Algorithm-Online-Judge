import java.util.*;
public class Main {


    static Map<Character, Integer> map = new HashMap<>();

    static char ret = 'A';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
        }
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(map.get(ch).equals(1)){
                ret = ch;
                break;
            }
        }
        
        if(ret == 'A'){
            System.out.print("None");
        }
        else{
            System.out.print(ret);
        }
    }
}
