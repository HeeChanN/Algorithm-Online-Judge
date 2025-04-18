#include <bits/stdc++.h>

using namespace std;

int n;
int idx,tmp,cnt;
int arr[20];
int num;
vector<int> v;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        cin >> tmp;
        cnt =0;
        for(int j=0;j<20;j++){
            cin >> arr[j];
            num = arr[j];
            idx = j;
            for(int k = j-1; k>=0;k--){
                if(arr[k] > num){
                    arr[idx] = arr[k];
                    idx = k;
                    cnt++;
                }
                else if(arr[k] < num){
                    break;
                }
            }
            arr[idx] = num;
        }
        v.push_back(cnt);
    }
    for(int i =0;i<v.size();i++){
        cout<<i+1 << " " << v[i]<<"\n";
    }
    return 0;
}
