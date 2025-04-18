#include<bits/stdc++.h>

using namespace std;

#define MAX 1000000

vector<bool> isPrime(MAX + 1, true);

vector<int> primes;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 2; i * i <= MAX; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }

    for (int i = 3; i <= MAX; i += 2) {
        if (isPrime[i]) 
        primes.push_back(i);
    }

    int num = 0;
    int x = 0;
    while(true){
        cin >> x;
        if(x==0){
            break;
        }
        for(int i =0;i<primes.size();i++){
            if (primes[i] >= x){
                cout << "Goldbach's conjecture is wrong.\n";
                break;
                
            }
            num = x - primes[i];
            if(num >=3 && isPrime[num]){
                cout << x << " = " << primes[i] << " + " << num << '\n';
                break;
            }
        }
    }
}
