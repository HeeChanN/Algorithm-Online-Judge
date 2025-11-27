import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            set.add(bCards[i]);
        }
        Arrays.sort(bCards);
        int idx = 0;
        int cnt = 0;
        for(int i = 1; i<= 2 * n;i++){
            if(set.contains(i)){
                continue;
            }
            if(bCards[idx] < i){
                cnt++;
                idx++;
            }
        }
        System.out.print(cnt);
    }
}
