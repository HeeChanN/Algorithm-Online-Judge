import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<n;i++){
            int point = sc.nextInt();
            int limit = sc.nextInt();
            arr.add(new int[] {limit, point});
        }

        Collections.sort(arr, Comparator.comparingInt(
            (int []a) -> a[0]
            )
            .thenComparingInt((int []a) -> -a[1])
        );
        int time = 1;
        int idx = 0;
        while(true){
            while(idx < arr.size() && arr.get(idx)[0] <= time){
                pq.offer(arr.get(idx)[1]);
                idx++;
            }
            while(pq.size() > time){
                pq.poll();
            }
            if(idx >= arr.size()){
                break;
            }
            time++;
        }
        int ret = 0;
        while(!pq.isEmpty()){
            ret += pq.poll();
        }
        System.out.println(ret);
    }
}
