import java.util.*;
public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int [] a)-> a[0])
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            pq.offer(new int[]{e,s});
        }
        int possible = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            if(possible <= cur[1]){
                possible = cur[0];
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
