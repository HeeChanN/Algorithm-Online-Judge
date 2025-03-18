#include<bits/stdc++.h>

using namespace std;

int s;

// y = 이모티콘 개수, x = 저장 값
int visited[1004][1004];
queue<pair<int,int>> q;


int bfs(){
    visited[1][0] = 1;
    q.push({1,0});
    int p;
    int stored;
    int t = 0;
    
    while(!q.empty()){
        int qSize = q.size();  
        for(int i = 0; i < qSize; i++) {
            int p = q.front().first;
            int stored = q.front().second;
            q.pop();

            if (p == s) return t;

            // 1. 복사 연산
            if (visited[p][p] != 1) {
                visited[p][p] = 1;
                q.push({p, p});
            }

            // 2. 붙여넣기 연산
            if (p + stored <= 1000 && visited[p + stored][stored] != 1) {
                visited[p + stored][stored] = 1;
                q.push({p + stored, stored});
            }

            // 3. 삭제 연산
            if (p - 1 >= 0 && visited[p - 1][stored] != 1) {
                visited[p - 1][stored] = 1;
                q.push({p - 1, stored});
            }
        }
        t++;
    }
    return -1; 
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> s;
    visited[0][0] = 1;
    cout << bfs();
}
