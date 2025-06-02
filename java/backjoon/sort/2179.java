import java.util.*;
import java.io.*;


// a  1,2
// b  0,3,4,5



class Main {
    
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();
    
    static String[] original = new String[20004];
    static Pair[] words;
    static int n;
    static String tmp;
    static int idx1 = 0;
    static int idx2 = 1;
    static int ret = -1;
    
    public static void main(String[] args) throws Exception{
        n = fs.nextInt(); 
        words = new Pair[n];
        for(int i = 0;i<n;i++){
            original[i] = fs.next();
            words[i] = new Pair(original[i],i);
            
        }
        Arrays.sort(words, Comparator.comparing((Pair p)-> p.word));
        
        int L = 0;
        for (int i = 0; i < n - 1; i++)
            L = Math.max(L, comp(words[i].word, words[i+1].word));


        int best1 = 987654321, best2 = 987654321;
        if (L > 0) {
            HashMap<String, Integer> firstSeen = new HashMap<>();
            for (int i = 0; i < n; i++){
                if(original[i].length() < L){
                    continue;
                }
                String key = original[i].substring(0, L);
                if(firstSeen.get(key) == null){
                    firstSeen.put(key, i);
                }
                else{
                    int idx = firstSeen.get(key);
                    if(idx < best1){
                        best1 = idx;
                        best2 = i;
                    }
                }
            }
        }

        System.out.println(original[best1]);
        System.out.println(original[best2]);
    }
    
    static int comp(String a, String b){
        int cnt = 0;
        int len = Math.min(a.length(), b.length());
        while(cnt < len && a.charAt(cnt) == b.charAt(cnt)){
            cnt++;
        }
        return cnt;
    }
    
    static class Pair{
        String word;
        int idx;
        
        public Pair(String word, int idx){
            this.word = word;
            this.idx = idx;
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
