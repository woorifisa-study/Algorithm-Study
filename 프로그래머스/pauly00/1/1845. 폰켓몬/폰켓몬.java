import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 1;
        for(int i=1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) continue;
            else sum++;
        }
        if(sum > (nums.length/2)) 
            return nums.length/2;
        return sum;
    }
}