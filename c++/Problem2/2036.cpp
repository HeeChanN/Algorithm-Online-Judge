#include <bits/stdc++.h>

using namespace std;

int n;
long long num;
vector<long long> m;
vector<long long> p;
long long ret;

bool comp(int a, int b){
    return a > b;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        cin >> num;
        if(num <= 0){
            m.push_back(num);
        }
        else if (num > 0){
            p.push_back(num);
        }
    }
    
    sort(m.begin(), m.end());
    long long sum = 1;
    int cnt= 0;
    for(int i = 0; i<m.size();i++){
        sum = sum * m[i];
        cnt++;
        if(cnt == 2){
            cnt = 0;
            ret = ret + sum;
            sum = 1;
        }
    }
    if(m.size() != 0 && m.size() % 2 == 1){
        ret = ret + sum;
    }
    sort(p.begin(), p.end(),comp);
    sum = 1;
    cnt= 0;
    for(int i = 0; i<p.size();i++){
        if(p[i] == 1 && cnt == 0){
            sum = 1;
        }
        else if (p[i] == 1 && cnt == 1){
            sum = sum + 1;
        }
        else{
            sum = sum * p[i];
        }
        cnt++;
        if(cnt == 2){
            cnt = 0;
            ret = ret + sum;
            sum = 1;
        }
    }
    if(p.size() != 0 && p.size() % 2 == 1){
        ret = ret + sum;
    }
    cout<<ret;
}
