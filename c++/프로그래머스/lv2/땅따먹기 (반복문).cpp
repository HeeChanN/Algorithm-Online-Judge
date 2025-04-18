int solution(vector<vector<int> > land)
{
    int answer = 0;
    memset(dp, 0, sizeof(dp));
    for(int i = land.size()-1; i>=0;i--){
        for(int j = 0;j<4;j++){
            for(int k = 0; k<4;k++){
                if(j != k){
                    dp[i][j] = max(dp[i][j], dp[i+1][k]);
                }
            }
            dp[i][j] = dp[i][j] + land[i][j];
        }
    }
    for(int i =0;i<4;i++){
        answer = max(answer, dp[0][i]);
    }

    return answer;
}
