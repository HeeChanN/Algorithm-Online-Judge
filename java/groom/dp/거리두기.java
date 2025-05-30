import java.io.*;
import java.util.*;

// 테이블 -> N * 3, 한줄에는 3개의 테이블, 줄이 총 N개
/* 이런 느낌? 한줄에는 3개의 테이블, 줄은 N개
o o o o o...
o o o o o...
o o o o o...
*/

// 테이블간 거리두기 -> 앉아있는 자리의 앞뒤, 양옆으로 인접한 테이블은 앉을수 없다.
// 테이블에 스티커를 붙일 수 있는 경우의 수를 구하기
// N <= 10만

// 1. 한줄당 총 5개의 좌석 경우의 수가 있음
// 0  1  2  3  1,3
// 이전이 0일 경우 모두 가능 
// 이전이 1일 경우 2,3만 가능
// 이전이 2일 경우 1,3만 가능
// 이전이 3일 경우 1,2만 가능
// 이전이 1,3 일경우 2만 가능

// 만약 stack overflow가 나면 -> C++로 코드 변경 or 반복문으로 코드 변경
// 반복문으로 변경하기 -> 1번 행부터 5개의 경우가 있음 따라서 0번에서 시작해서 1번을 앉을 때 가능한지 여부 확인하기

class Main {

	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	static int n;
	static long [][] dp = new long[100004][5];

	
	public static void main(String[] args) throws Exception {
		n = fs.nextInt();
		Arrays.fill(dp[0],1);
		for(int i = 0;i<n;i++){
			for(int prev = 0;prev<5;prev++){
				long v = dp[i][prev];
				if(v == 0){
					continue;
				}
				for(int j=0;j<5;j++){
					// 지금 좌석에서 다음 가능한 좌석 판단
					// 예를 들어 0번 좌석에서 0을 선택했을 때 다음 좌석 선택가능한지 판단하고 선택 가능하면 더해주기
					if(isAllowed(prev,j)){
						dp[i+1][j] = (dp[i+1][j] + v) % 100000007;
					}
				}
			}
		}
		long ans = 0;
        for (int p = 0; p < 5; p++) 
			ans = (ans + dp[n-1][p]) % 100000007;
        System.out.println(ans);
	}

	private static boolean isAllowed(int prev, int nxt) {
        return  (nxt == 0) ||
               (nxt == 1 && prev != 4 && prev != 1) ||
               (nxt == 2 && prev != 2) ||
               (nxt == 3 && prev != 4 && prev != 3) ||
               (nxt == 4 && (prev == 0 || prev == 2));
    }

	// static long go(int idx, int pCase){
	// 	if(idx == n){
	// 		return 1;
	// 	}
	// 	if(dp[idx][pCase] != 0){
	// 		return dp[idx][pCase];
	// 	}
	// 	for(int i = 0;i<5;i++){
	// 		if(i == 0){
	// 			dp[idx][pCase] += go(idx+1,i);
	// 		}
	// 		if(i == 1 && pCase != 4  && pCase != i){
	// 			dp[idx][pCase] += go(idx+1,i);
	// 		}
	// 		if(i == 2 && pCase != i){
	// 			dp[idx][pCase] += go(idx+1,i);
	// 		}
	// 		if(i == 3 && pCase != 4 && pCase != i){
	// 			dp[idx][pCase] += go(idx + 1, i);
	// 		}
	// 		if(i == 4 && (pCase == 0 || pCase == 2)){
	// 			dp[idx][pCase] += go(idx + 1,i);
	// 		}
	// 	}
	// 	return dp[idx][pCase] = dp[idx][pCase] % 100000007;
	// }

	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception{
			while(st == null || !st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
	}
}
