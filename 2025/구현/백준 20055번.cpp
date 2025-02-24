#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    vector<int> A(2*N);
    for(int i = 0; i < 2*N; i++){
        cin >> A[i];
    }

    vector<bool> robot(2*N, false);

    int broken = 0;
    int step = 0;    

    while(true){
        step++;

        {
            int temp = A[2*N - 1];
            for(int i = 2*N - 1; i > 0; i--){
                A[i] = A[i - 1];
            }
            A[0] = temp;

            bool tmpRobot = robot[2*N - 1];
            for(int i = 2*N - 1; i > 0; i--){
                robot[i] = robot[i - 1];
            }
            robot[0] = tmpRobot;

            if(robot[N - 1]) {
                robot[N - 1] = false;
            }
        }

        for(int i = N - 2; i >= 0; i--){
   
            if(robot[i] && !robot[i + 1] && A[i + 1] > 0){
                robot[i] = false;
                robot[i + 1] = true;
                A[i + 1]--;        
                if(A[i + 1] == 0) { 
                    broken++;
                }
            }
 
            if(robot[N - 1]) {
                robot[N - 1] = false;
            }
        }


        if(A[0] > 0){
            robot[0] = true;  
            A[0]--;            
            if(A[0] == 0) {
                broken++;
            }
        }

        if(broken >= K) {
            cout << step << "\n";
            break;
        }
    }

    return 0;
}
