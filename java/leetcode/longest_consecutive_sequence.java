import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length;i++){
            set.add(nums[i]);
        }
        int ret = 0;
        for(int i = 0; i<nums.length;i++){
            int prevNumber = nums[i] - 1;
            if(set.contains(prevNumber)){
                continue;
            }
            int cnt = 1;
            int nextNumber = nums[i] + 1;
            while(set.contains(nextNumber)){
                cnt++;
                nextNumber++;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}
