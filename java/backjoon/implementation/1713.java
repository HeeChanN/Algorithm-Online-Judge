import java.util.*;
import java.io.*;

class Main {
    
    // order는 클 수록 최신임
    static class Person{
        int id;
        int order;
        
        public Person(int id, int order){
            this.id = id;
            this.order = order;
        }
    }
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Person> arr = new ArrayList<>();
    static ArrayList<Integer> ret = new ArrayList<>();
    static int n,len;
    static int [] cnt;
    
    public static void main(String[] args) throws Exception {
        len = fs.nextInt();
        n = fs.nextInt();
        
        cnt = new int[n + 1];
        for(int i = 0; i<n;i++){
            int num = fs.nextInt();
            // 처음 추천
            if(cnt[num] == 0){
                // 1. 자리가 남아 있는 경우
                if(arr.size() < len){
                    arr.add(0,new Person(num,i));
                    cnt[num]++;
                    // 재배치 필요 (앞에서부터)
                    reorderFront();
                }
                // 2. 꽉차 있는 경우
                else{
                    Person prev = arr.get(len-1);
                    cnt[prev.id] = 0;
                    arr.set(len-1,new Person(num,i));
                    cnt[num]++;
                    //재배치 필요
                    reorderEnd(len-1);
                }
            }
            // 추천 수 증가
            else{
                cnt[num]++;
                for(int j = 0; j<arr.size();j++){
                    Person tmp = arr.get(j);
                    if(tmp.id == num){
                        reorderEnd(j);
                        break;
                    }
                }
            }
        }
        for(int i = 0;i<arr.size();i++){
            ret.add(arr.get(i).id);
        }
        Collections.sort(ret);
        for(int i = 0; i<ret.size();i++){
            sb.append(ret.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    
    static void reorderFront(){
        for(int i = 0; i<arr.size()-1;i++){
            Person a = arr.get(i);
            Person b = arr.get(i+1);
            if(cnt[a.id] < cnt[b.id]){
                //swap 하기
                Person tmp = a;
                arr.set(i,b);
                arr.set(i+1,tmp);
            }
            else{
                break;
            }
        }
    }
    
    static void reorderEnd(int idx){
        for(int i = idx;i>=1;i--){
            Person a = arr.get(i);
            Person b = arr.get(i-1);
            if((cnt[a.id] > cnt[b.id] ) || (cnt[a.id] == cnt[b.id] && a.order > b.order)){
                Person tmp = a;
                arr.set(i,b);
                arr.set(i-1,tmp);
            }
            else{
                break;
            }
        }
    }

    static class FastScanner {
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
