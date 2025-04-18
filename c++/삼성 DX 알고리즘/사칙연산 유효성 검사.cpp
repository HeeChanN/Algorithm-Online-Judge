#include <bits/stdc++.h>

using namespace std;

int n;

int main(){
    
    for(int i = 1; i<=10;i++){
        cin >> n;
        int flag = 1;

        for(int j =0;j<n;j++){
            int num;
            char ch;
            cin>>num >> ch;
                
            if(num * 2 <= n){
               int a,b;
                if( num *2 == n && n%2 == 0)
                    cin >> a;
                else
                    cin >> a >> b;
              
                if (ch >= '0' && ch <= '9')
                    flag = 0;
            }
            else{
                if(ch== '-' || ch== '+' || ch == '/' || ch == '*')
                    flag = 0;
            }
        }
        
        cout<<"#"<<i<<" "<<flag << "\n";
    }
    return 0;
}
