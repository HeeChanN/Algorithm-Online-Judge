import java.util.*;

public class Main {

    static long ret = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long [] arr = new long[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextLong();
        // Please write your code here.
        long left = 1;
        long right = Long.MAX_VALUE;

        while(left <= right){
            long mid = left + (right - left) / 2;

            long cnt = 0;
            for(int i = 0; i<m;i++){
                cnt += mid / arr[i];
            }
            if(cnt >= n){
                ret = Math.min(ret, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            
        }
        System.out.print(ret);
    }
}
