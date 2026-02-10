import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count0 = 0;
        int count1 = 0;

        if (s.charAt(0) == '1') {
            count0++;
        } else {
            count1++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '1') {
                    count0++;
                } 
  
                else {
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));
        
        sc.close();
    }
}
