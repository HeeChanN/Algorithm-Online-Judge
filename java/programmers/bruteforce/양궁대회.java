class Solution {
    
    static int [] visited = new int[11];
    static int [] infos = new int[11];
    static int [] tmp = new int [11];
    static int N;
    static int ret = 0;
    
    public int[] solution(int n, int[] info) {
        int[] answer;
        N = n;
        for(int i = 0; i<11;i++){
            infos[i] = info[i];
        }
        go(0,n);
        if(ret == 0){
            answer = new int[]{-1};
        }
        else{
            answer = tmp;
        }
        return answer;
    }
    
    public void go(int idx,int cnt){
        if(cnt < 0){
            return ;
        }
        if(cnt == 0 || idx == 10){
            visited[10] += cnt;
            calcScore(cnt);
            visited[10] -= cnt;
            return;
        }
        visited[idx] = infos[idx] + 1;
        go(idx+1, cnt-(infos[idx] + 1));
        visited[idx] = 0;
        go(idx+1, cnt);
    }
    
    static void calcScore(int cnt){
        int lion = 0;
        int apeach = 0;
        for(int i = 0; i<11;i++){
            if(visited[i] != 0){
                lion += (10 - i);
            }
            else if (infos[i] != 0){
                apeach += (10-i);
            }
        }
        int diff = lion - apeach;
        if(lion < apeach || diff < ret){
            return;
        }
        if(diff > ret){
            for(int j = 0; j<11;j++){
                tmp[j] = visited[j];
            }
            ret = diff;
        }
        else{
            for(int i = 10; i>=0;i--){
                if(tmp[i] < visited[i]){
                    for(int j = 0; j<11;j++){
                        tmp[j] = visited[j];
                    }
                    ret = diff;
                    break;
                }
                if(tmp[i] > visited[i]){
                    break;
                }
            }
        }
    }

}
