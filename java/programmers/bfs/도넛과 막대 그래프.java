// https://school.programmers.co.kr/learn/courses/30/lessons/258711?language=java

import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<Integer>[] adj = new ArrayList[1000001];
    static int [] arr = new int[1000001];
    static int [] visited = new int[1000001];
    static int[] answer = new int[4];
    
    static int k = 0;
    static int n = 0;
    static int e = 0;
    
    static public int[] solution(int[][] edges) {
        
        for(int i =0; i<1000001;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int [] edge : edges){
            adj[edge[0]].add(edge[1]);
            arr[edge[1]]++;
            k = Math.max(k, edge[0] > edge[1] ? edge[0] : edge[1]);
        }
        
        for(int i = 1; i<=k;i++){
            if(arr[i] == 0 && adj[i].size() >=2){
                answer[0] = i;
                break;
            } 
        }
        
        for(int next : adj[answer[0]]){
            bfs(next);
            classifyType();
        }
        
        return answer;
    }
    
    static void classifyType(){
        if(n == e){
            answer[1]++;
        }
        else if(n -1 == e){
            answer[2]++;
        }
        else{
            answer[3]++;
        }
        n = 0;
        e = 0;
    }
    
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;
        n++;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                e++;
                if(visited[next] == 0){
                    q.offer(next);
                    n++;
                    visited[next] = 1;
                }
            }
        }
    }
}
