import java.util.*;

// 1. n은 <= 10만이기 때문에 이중 반복문은 불가능함
// 2. 투포인터 이용하자
// 3. 넓이를 일단 가장 크게 고정
// left = 0, right = n-1;
// 이후 높이가 큰게 나오지 않을까?라는 관점으로 이동시키기 높이가 짧은 쪽을 이동시키기

class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            ret = Math.max(ret, h * width);
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ret;
    }
}
