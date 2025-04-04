#include<bits/stdc++.h>

using namespace std;

int max_num = 0;
int min_num = 987654321;

int odd(int n) {
	int oddnum = 0;
	while (n > 0) {
		int num = n % 10;
		if (num % 2 == 1) oddnum++;
		n /= 10;
	}
	return oddnum;
}
void go(int s, int sumOfOdds){
    sumOfOdds+= odd(s);
    
    if(s < 10){
        min_num = min(min_num, sumOfOdds);
        max_num = max(max_num, sumOfOdds);
        return;
    }
    else if(s < 100){
       int new_num = s/10 + s%10;
       go(new_num,sumOfOdds);
    }
    else{
        string num = to_string(s);
        for (int i = 1; i < num.size(); i++) {
            for (int j = i+1; j < num.size(); j++) {
                string part1 = num.substr(0, i);
                string part2 = num.substr(i, j - i);
                string part3 = num.substr(j);

                int tmp = stoi(part1) + stoi(part2) + stoi(part3);

                go(tmp, sumOfOdds);
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	int s;
	cin >> s;
    go(s , 0);
    cout << min_num << " "<<max_num;
}
