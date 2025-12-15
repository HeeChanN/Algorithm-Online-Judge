class Solution {
    public int missingNumber(int[] nums) {
        int [] exist = new int[nums.length+1];
        for(int i = 0; i<nums.length;i++){
            exist[nums[i]] = 1;
        }
        
        for(int i = 0; i<exist.length;i++){
            if(exist[i] == 0){
                return i;
            }
        }
	    return 0;
    }
}
