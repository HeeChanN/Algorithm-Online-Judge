import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String L = sc.next();
        String R = sc.next();

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }
        
        int count = 0;
        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) != R.charAt(i)) {
                break;
            }
            if (L.charAt(i) == '8') {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}
