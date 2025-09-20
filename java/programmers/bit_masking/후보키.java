import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        List<Integer> keys = new ArrayList<>();


        for (int size = 1; size <= m; size++) {
            for (int mask = 1; mask < (1 << m); mask++) {
                if (Integer.bitCount(mask) != size) continue;
                
                boolean violate = false;
                for (int k : keys) {
                    if ((k & mask) == k) {
                        violate = true;
                        break;
                    }
                }
                if (violate) continue;
                
                HashSet<String> set = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    StringBuilder sb = new StringBuilder();
                    for (int c = 0; c < m; c++) {
                        if ((mask & (1 << c)) != 0) {
                            sb.append(relation[r][c]);
                        }
                    }
                    set.add(sb.toString());
                }
                if (set.size() == n) {
                    keys.add(mask);
                }
            }
        }
        return keys.size();
    }
}
