import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, ArrayList> map = new HashMap<>();
        int [] answer = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> arr = map.get(nums[i]);
                arr.add(i);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(nums[i], arr);
            }
        }

        for(int i = 0; i< nums.length; i++){
            int diff = target - nums[i];
            //System.out.println("pos : " + i + " " + diff);
            if(map.containsKey(diff)){
                //System.out.println(i + " " + diff);
                ArrayList<Integer> arr = map.get(diff);
                //System.out.println(arr.size());
                if(diff == nums[i] && arr.size() > 1){
                    answer[0] = arr.get(0);
                    answer[1] = arr.get(1);
                    break;
                }
                else if(diff != nums[i]){
                    answer[0] = i;
                    answer[1] = arr.get(0);
                    break;
                }
            }
        }
        return answer;
    }
}
