import java.util.*;

class Solution {

    static Set<String> set;
    static int n;
    static String str;
    static int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        str = s;
        set = new HashSet<>();
        dp = new int[n+1];
        for(int i = 0; i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        //System.out.println(n + " " + ret);
        Arrays.fill(dp, -1);
        dfs(0);
        for(int i = 0; i<n;i++){
            if(dp[i] > 0){
                return true;
            }
        }
        return false;
    }

    static int dfs(int start){
        //System.out.println(start + " " + end);
        if(start == n){
            return 1;
        }
        if(dp[start] != -1){
            return dp[start];
        }
        int end = start+1;
        while(true){
            String tmp = str.substring(start,end);
            //System.out.println(tmp);
            int flag = 0;
            if(set.contains(tmp)){
                flag = dfs(end);
            }
            if(flag == 1){
                dp[start] = 1;
                return dp[start];
            }
            end++;
            if(end > n){
                dp[start] = 0;
                return dp[start];
            }
        }
    }
}
