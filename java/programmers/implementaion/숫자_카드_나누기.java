import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = Math.max(answer, calculate(arrayA, arrayB));
        answer = Math.max(answer, calculate(arrayB, arrayA));
        
        return answer;
    }
    
    static int calculate(int[] src, int [] target){
        int numA, numB;
        if(src.length == 1){
            numA = src[0];
        }
        else{
            numA = gcd(src[0], src[1]);
            for(int i = 2; i<src.length;i++){
                numA = gcd(numA, src[i]);
                if(numA == 1){
                    break;
                }
            }
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 1; i*i<=numA;i++){
            if(numA % i != 0){
                continue;
            }
            tmp.add(i);
            tmp.add(numA/i);
        }
        Collections.sort(tmp, Comparator.comparingInt((Integer a) -> -a));
        for(int i = 0; i<tmp.size();i++){
            int t = tmp.get(i);
            int flag = 0;
            for(int j = 0;j<target.length;j++){
                if(target[j] % t == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return t;
            }
        }
        return 0;
    }
    
    static int gcd(int a, int b){
        if(b != 0){
            return gcd(b, a%b);
        }
        return a;
    }
}
