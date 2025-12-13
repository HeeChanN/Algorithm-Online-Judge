import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] people = new int[n][3]; // [0] : 도착시간, [1]: 머무른 시간

        for (int i = 0; i < n; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
            people[i][2] = i+1;
        }
        
        Arrays.sort(people, Comparator.comparingInt((int [] a) -> a[0]));

        long time = 0;
        int done = 0;
        int idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] a)-> a[0])
        );
        long answer = 0;

        while(done < n){
            //System.out.println(people[idx][0]);
            while(idx < n && (int)time >= people[idx][0]){
                pq.offer(new int[]{people[idx][2], people[idx][0], people[idx][1]});
                idx++;
            }

            if(pq.isEmpty()){
                time = people[idx][0];
                //System.out.println("check");
                continue;
            }

            int [] person = pq.poll();
            int waitingTime = (int)Math.max(time - person[1],0L);
            //System.out.println(person[0] + " " + person[1] + " " + person[2] +" "+ waitingTime + " " + time);
            time += person[2];
            answer = Math.max(answer, waitingTime);
            done++;
        }
        System.out.print(answer);
    }
}
