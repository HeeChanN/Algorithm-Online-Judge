import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();


        int ret = 0;
        int pos = 0;
        for(int i = 1; i<n;i++){
            if(prices[i] > prices[pos]){
                ret = Math.max(ret, prices[i] - prices[pos]);
            }
            else {
                pos = i;
            }
        }
        System.out.print(ret);
    }
}
