#include<bits/stdc++.h>

using namespace std;

int mine[3][3] = {
    {1,1,1},
    {5,1,1},
    {25,5,1}
};

int arr[12][3];
int visited[12];

int go(string s, int idx){
    if(s[0] == 'd'){
        return mine[idx][0];
    }
    else if(s[0] == 'i'){
        return mine[idx][1];
    }
    else{
        return mine[idx][2];
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    
    int i = 0;
    int cnt = 0;
    while(i < minerals.size()){
        arr[i/5][0]=arr[i/5][0]+go(minerals[i],0); // dia
        arr[i/5][1]=arr[i/5][1]+go(minerals[i],1); // iron
        arr[i/5][2]=arr[i/5][2]+go(minerals[i],2); // rock
        if(i%5 == 0){
            cnt++;
        }
        i++;
    }
    int sum = picks[0] + picks[1] + picks[2];
    int flag = 0;
    while(true){
        if(flag == 3){
            break;
        }
        int num = picks[flag];
        if(num == 0){
            flag++;
            continue;
        }
        int ret = 0;
        int tmp = -1;
        for(int i = 0; i<cnt;i++){
            if(i >= sum){
                break;
            }
            if(visited[i] == 0 && arr[i][2] > ret){
                ret = arr[i][2];
                tmp = i;
            }
        }
        if(tmp == -1){
            break;
        }
        visited[tmp] = 1;
        answer = answer + arr[tmp][flag];
        picks[flag]--;
    }
    
    
    return answer;
}
