import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int N = nums.length;        
        int unique = set.size();
        
        return Math.min(N / 2, unique);    
    }
}