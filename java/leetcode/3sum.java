import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i< n-2;i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }

            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    int leftValue = nums[left];
                    while(left < right && leftValue == nums[left]){
                        left++;
                    }

                    int rightValue = nums[right];
                    while(left < right && rightValue == nums[right]){
                        right--;
                    }
                    ret.add(List.of(nums[i], leftValue, rightValue));
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ret;
    }
}
