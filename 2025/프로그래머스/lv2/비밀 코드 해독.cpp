#include <bits/stdc++.h>

using namespace std;

vector<int> v;
vector<vector<int>> realq;
vector<int> realAns;
int ret;

void comb(int pos, int num){
    if(v.size() == 5){
        for(int i = 0;i<realq.size();i++){
            int cnt = 0;
            for(int j = 0;j<5;j++){
                for(int k =0;k<5;k++){
                    if(v[j] == realq[i][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(realAns[i] != cnt){
                return;
            }
        }
        ret++;
        return;
    }
    
    for(int i = pos+1; i<=num-4;i++){
        v.push_back(i);
        comb(i,num+1);
        v.pop_back();
    }
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    
    realq = q;
    realAns = ans;
    
    comb(0,n);
    
    cout << ret;
    return ret;
}
