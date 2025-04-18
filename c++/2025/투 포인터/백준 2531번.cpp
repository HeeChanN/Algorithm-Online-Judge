#include<bits/stdc++.h>

using namespace std;

int n, d, k, c;
vector<int> dish;
queue<int> q;

int tmp;
int visited[3004];
int ret, sum;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>> n >> d >> k >> c;
    
    //입력
    for(int i = 0;i<n;i++){
        cin >> tmp;
        dish.push_back(tmp);
    }
    
    //k개 선택
    for(int i = 0; i<k;i++){
        tmp = dish[i];
        q.push(tmp);
        if(visited[tmp] == 0){
            sum++;
        }
        visited[tmp]++;
    }
    if(visited[c] == 0){
        ret = sum +1;
    }
    else{
        ret = sum;
    }
    
    //모든 가능한 k개 선택 경우 확인
    for(int i = 1; i<n;i++){
        int num = q.front();
        q.pop();
        visited[num]--;
        if(visited[num]==0){
            sum--;
        }
        
        int next_num = dish[(k+i-1)%n];
        q.push(next_num);
        if(visited[next_num] == 0){
            sum++;
        }
        visited[next_num]++;
        
        if(visited[c] == 0){
            ret = max(ret, sum+1);
        }
        else{
            ret = max(ret, sum);
        }
    }
    cout<<ret;
}
