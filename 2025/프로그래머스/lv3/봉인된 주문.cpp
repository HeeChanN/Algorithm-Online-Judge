#include<bits/stdc++.h>

using namespace std;


bool comp(string a, string b){
    if(a.size() != b.size()){
        return a.size() < b.size();
    }
    return a < b;
}

string solution(long long n, vector<string> bans) {
    string answer = "";
    
    long long num = 26;
    int len = 0;
    for(int i = 1; i<=11;i++){
        if(num >= n){
            len = i;
            break;
        }
        n = n-num;
        num = num *26;
    }
    
    sort(bans.begin(), bans.end(),comp);

    for(int i = 0; i<bans.size();i++){
        string str = bans[i];
        if(str.size() < len){
            n=n+1;
        }
        else if (str.size() == len){
            int pos = 0;
            long long s = 0;
            for(int j=str.size()-1;j>=0;j--){
                s = s + (str[j] - 'a') * pow(26,pos); 
                pos++;
            }
            if(s+1 <= n){
                n=n+1;
            }
        }
        else{
            break;
        }
        if(num < n){ // 주문 삭제중 결과값의 순위의 길이가 증가할 수 있음
            len = len + 1;
            n = n - num;
            num = num *26;
        }
    }
    
    cout << n;
    n--;
    while(true) {
        long long r = n % 26;    
        answer.push_back((char)('a' + r));
        n = n / 26;
        if(n == 0) break;  
    }
    
    reverse(answer.begin(), answer.end());
    
    if(answer.size() < len) {
        string prefix(len - answer.size(), 'a');
        answer = prefix + answer;
    }

    return answer;
}
