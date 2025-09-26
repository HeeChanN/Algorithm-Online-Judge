import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(sb.length() <= t * m){
            String v = Integer.toString(num, n).toUpperCase();
            num++;
            sb.append(v);
        }
        p = p -1;
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i<t;i++){
            ret.append(sb.charAt(p));
            p = p + m;
        }
        return ret.toString();
    }
}
