import java.util.*;


// 제자리 -> 가중치 1
// 상하좌우 이동 -> 가중치 2
// 대각선 읹버 숫자 -> 가중치 3
// 인접하지 않은 경우 가중치 합이 최소가 되는 경로를 따른다.

// 첫 시작은 4, 6
// 최소한의 시간으로 타이핑 하는 경우의 가중치 합
// numbers <= 10만

class Solution {
    
    static int [][][] dp = new int[100004][10][10];
       static int[][] positions = {
        {3,1}, // 0
        {0,0}, {0,1}, {0,2}, // 1, 2, 3
        {1,0}, {1,1}, {1,2}, // 4, 5, 6
        {2,0}, {2,1}, {2,2}  // 7, 8, 9
    };
    
    public int solution(String numbers) {
        int answer = Integer.MAX_VALUE;
        
        for(int [][] arr : dp){
            for(int [] row : arr){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        dp[0][4][6] = 0;
        
        for(int i = 0; i<numbers.length();i++){
            int target = numbers.charAt(i) - '0';
            
            for(int left = 0; left < 10; left++){
                for(int right = 0; right < 10; right++){
                    if(dp[i][left][right] == Integer.MAX_VALUE){
                        continue;
                    }
                    int currentCost = dp[i][left][right];
                    
                    // 왼손을 target으로 이동
                    int moveCostL = calculateWeight(left, target);
                    if (right != target && dp[i+1][target][right] > currentCost + moveCostL) {
                        dp[i+1][target][right] = currentCost + moveCostL;
                    }
                    
                    // 오른손을 target으로 이동
                    int moveCostR = calculateWeight(right, target);
                    if (left != target && dp[i+1][left][target] > currentCost + moveCostR) {
                        dp[i+1][left][target] = currentCost + moveCostR;
                    }
                }
            }
        }
        for(int left = 0; left<10; left++){
            for(int right = 0; right < 10; right++){
                answer = Math.min(answer, dp[numbers.length()][left][right]);
            }
        }
        
        return answer;
    }
    
    static int calculateWeight(int start, int end) {
        if (start == end){
          return 1;  
        }         
        
        int r1 = positions[start][0];
        int c1 = positions[start][1];
        int r2 = positions[end][0];
        int c2 = positions[end][1];
        
        int diffR = Math.abs(r1 - r2);
        int diffC = Math.abs(c1 - c2);

        int diagonal = Math.min(diffR, diffC);
        int straight = Math.abs(diffR - diffC);
        
        return (diagonal * 3) + (straight * 2);
    }
}
