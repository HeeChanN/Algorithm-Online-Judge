import java.util.*;
import java.io.*;

// d km 고속도로

// 지름길 파악
// 모든 지름길은 일방 통행
// 고속도로는 역주행 불가

// 지름길의 개수 N, 고속도로의 길이 D
// 1<= N <= 12, 1<= D <=10000

// 지름길의 시작위치, 도착위치, 지름길 길이


// 1. 기본 운전거리는 D
// 2. 시작 위치 = 0 끝나는 위치는 D+1
// 시작위치부터 움직인 거리 추가해가며 
// 지름길을 이용할지/이용하지 않을지 선택하기
// 2^12 = 4096


class Main {
    
    static FastScanner fs = new FastScanner();
    static int n,d;
    static ArrayList<int[]> roads = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt();
        d = fs.nextInt();
        for(int i = 0;i<n;i++){
            int s = fs.nextInt();
            int e = fs.nextInt();
            int dist = fs.nextInt();
            roads.add(new int[]{s,e,dist});
        }
        roads.sort(Comparator.comparingInt((int [] a)-> a[0]));
        
        System.out.print(logic(0,0));
    }
    
    static int logic(int pos, int idx){
        if(idx == n){
            return (d) - pos;
        }
        int [] road = roads.get(idx);
        int s = road[0];
        int e = road[1];
        int dist = road[2];
        int result = 987654321;
        if(pos <= s && e <= d){
            result = logic(e,idx+1) + s-pos + dist;
        }
        result = Math.min(result, logic(pos,idx+1));
        return result;
    }
    
    static void print(){
        for(int [] road : roads){
            System.out.println(road[0] + " " + road[1] + " " + road[2]);
        }
    }
    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() throws Exception{
            while(st == null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }
    }
}
