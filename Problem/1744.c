#include <bits/stdc++.h>

using namespace std;

bool comp(int a, int b){
    return a > b;
}

int n,sum;
vector<int> m;
vector<int> p;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n;
    
    for(int i =0;i<n;i++){
        int num;
        cin>>num;
        if(num <= 0){
            m.push_back(num);
        }
        else{
            p.push_back(num);
        }
    }
    
    sort(p.begin(),p.end(),comp);
    sort(m.begin(),m.end());
    
    for(int i = 0;i<(p.size() -1) ;i = i +2){
        if(p.size() == i || p.size() == i+1){
            break;
        }
        sum = sum + max(p[i] * p[i +1],p[i] + p[i+1]);
    }
    if(p.size()%2 == 1){
        sum = sum + p[p.size()-1];
    }
    // cout<<sum<<" "<<m.size()<<"\n";
    
    for(int i = 0; i<(m.size() -1);i = i+2){
        if(m.size() == i || m.size() == i+1){
            break;
        }
        sum = sum + max(m[i] * m[i +1],m[i] + m[i+1]);
    
    }
    if(m.size()%2 == 1){
        sum = sum + m[m.size()-1];
    }
    
    cout<<sum;
    
    
}
