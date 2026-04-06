import java.util.*;

class Solution {
    public int solution(int[] nums) { // nums: N마리 폰켓몬의 종류 번호
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int halfSize = nums.length/2;
        int answer = 0;
        
        for(Integer num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if(map.size() >= halfSize){
            answer = halfSize;
        } else{
            answer = map.size();
        }
        
        return answer; // 포켓몬 종류 번호의 개수(최대한 다양한 종류)
    }
}