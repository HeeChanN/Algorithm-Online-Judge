#include<bits/stdc++.h>

using namespace std;

int n;
int flag;
int cnt;
int p_num, l_num,r_num;
int last_node;
vector<int> tree[100004];
stack<int> s;

void go(int node){
    if(tree[node][0] != -1){
        cnt++;
        go(tree[node][0]);
    }
    if(tree[node][1] != -1){
        cnt++;
        go(tree[node][1]);
    }
    if(node != last_node && flag == 0){
        cnt++;
    }
    if(node == last_node){
        flag = 1;
    }
}

void find_last_node(int node){
    if(tree[node][0] != -1){
        find_last_node(tree[node][0]);
    }
    s.push(node);
    if(tree[node][1] != -1){
        find_last_node(tree[node][1]);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0; i<n;i++){
        cin >> p_num >> l_num >> r_num;
        tree[p_num].push_back(l_num);
        tree[p_num].push_back(r_num);
    }
    
    find_last_node(1);
    last_node = s.top();
    go(1);
    cout<< cnt;
}
