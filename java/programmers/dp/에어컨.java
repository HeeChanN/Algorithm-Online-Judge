//https://school.programmers.co.kr/learn/courses/30/lessons/214289

import java.util.*;

class Solution {
    
    static int outTemp;
    static int l,r;
    static int aa, bb;
    static int v,limit;
    static int [] arr;
    static int [][][] dp = new int[1000][52][2];
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        outTemp = temperature + 10;
        l = t1 + 10;
        r = t2 + 10;
        aa = a;
        bb = b;
        arr = new int[onboard.length];
        for(int i = 0; i<onboard.length;i++){
            arr[i] = onboard[i];
        }
        if(outTemp < l){
            v = 1;
            limit = 50;
        }
        else if (outTemp > r){
            v = -1;
            limit = 0;
        }
        else{
            return 0;
        }
        for(int [][]s : dp){
            for(int [] row : s){
                Arrays.fill(row,987654321);
            }
        }
        
        int on = go(0,outTemp,1);
        int off = go(0,outTemp,0);
        
        
        return Math.min(on,off);
    }
    
    static int go(int idx, int temp, int flag){
        if(!isValidated(temp)){
            return 987654321; 
        }
        if(arr[idx] == 1 && (temp < l || temp > r)){
            return 987654321;
        }
        if(idx == arr.length-1){
            return 0;
        }
        if(dp[idx][temp][flag] != 987654321){
            return dp[idx][temp][flag];
        }
        if(flag == 1){
            int down = go(idx+1,temp+v,1) + aa;
            int offDown = go(idx+1, temp+v, 0) + aa;
            int keep = go(idx+1,temp,1) + bb;
            int offKeep = go(idx+1,temp,0) + bb;
            int tmp = Math.min(down, offDown);
            tmp = Math.min(tmp, keep);
            tmp = Math.min(tmp, offKeep);
            dp[idx][temp][flag] = tmp;
            return dp[idx][temp][flag];
        }
        else{
            int on = go(idx+1, calc(temp),1);
            int off = go(idx+1, calc(temp),0); 
            dp[idx][temp][flag] = Math.min(on,off);
            return dp[idx][temp][flag];
        }
    }
    
    static boolean isValidated(int temp){
        if(v==-1){
            if(temp < 0) {
                return false;
            }
            return true;
        }
        else{
            if(temp>50){
                return false;
            }
            return true;
        }
    }
    
    static int calc(int temp){
        if (v == -1){
            return Math.min(outTemp, temp-v);
        }
        else{
            return Math.max(outTemp, temp-v);
        }
    }
}
