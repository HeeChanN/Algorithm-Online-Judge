#include <bits/stdc++.h>

using namespace std;

class Node{
    public:
        map<char, Node> child;
        bool isLast;
        
    Node(){
        isLast = false;
    }
};

int k;
string ret = "";
int cnt;

void insert(Node &node, string str, int idx){
    if(str.length() == idx){
        node.isLast = true;
        return;
    }
    if(node.child.count(str[idx]) == 0){
        node.child[str[idx]] = Node();
    }
    
    insert(node.child[str[idx]], str, idx + 1 );
}

void find_k(Node &node, string str, int idx){
    if(node.isLast){
        //cout<<str<<"\n";
        cnt++;
        if (cnt == k){
            ret = str;
        }
    }
    for( auto children : node.child){
        find_k(children.second, str + children.first, idx + 1);
    }
}

void print_all(Node& node, string str, int index) {
    if (node.isLast) {
        cout << str << "\n";
    }

    for (auto children : node.child) {
        print_all(children.second, str + children.first, index + 1);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin>> t;
    for(int i = 1; i<=t;i++){
        
        string str;
        Node root;
        cnt = 0;
        ret = "";
        
        cin >> k;
        cin >> str;
        
        for(int i = 0; i<str.length();i++){
            insert(root, &str[i], 0);
        }
        
        //print_all(root,"",0);
        find_k(root, "", 0);
        if(ret == ""){
            ret = "none";
        }
        cout<<"#"<<i << " " << ret<<"\n";
    }
    
}
