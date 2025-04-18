#include<bits/stdc++.h>

using namespace std;

int n,num,cnt;
int arr[52][2];
vector<int> r;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;

    for(int i =0;i<n;i++){
        cin >>arr[i][0] >> arr[i][1];
    }
    
    for(int i = 0; i<n;i++){
        cnt = 0;
        for(int j = 0;j<n;j++){
            if(i == j) continue;
            if((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])){
                cnt++;
            }
        }
        r.push_back(cnt+1);
    }
    for(int i = 0; i<n;i++){
        cout << r[i] << " ";
    }
}
