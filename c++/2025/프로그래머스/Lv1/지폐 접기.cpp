#include<bits/stdc++.h>

using namespace std;

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;
    
    sort(wallet.begin(), wallet.end());
    sort(bill.begin(), bill.end());
    
    while(1){
        if(wallet[0] < bill[0]){
            bill[1] = bill[1] / 2;
            answer++;
            sort(bill.begin(),bill.end());
        }
        else{
            if(wallet[1] < bill[1]){
                bill[1] = bill[1] / 2;
                answer++;
                sort(bill.begin(),bill.end());
            }
            else{
                break;
            }
        }
    }
    return answer;
}
