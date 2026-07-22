import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        Map<Integer, Long> map = new HashMap<>();
        
        for(int w : weights){
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        
        long answer = 0;
        
        for(int w : map.keySet()){
            
            long cnt = map.get(w);
            
            // 같은 몸무게
            answer += cnt * (cnt - 1) / 2;
            
            // 2 : 3
            if(w % 2 == 0){
                answer += cnt * map.getOrDefault(w * 3 / 2, 0L);
            }
            
            // 1 : 2
            answer += cnt * map.getOrDefault(w * 2, 0L);
            
            // 3 : 4
            if(w % 3 == 0){
                answer += cnt * map.getOrDefault(w * 4 / 3, 0L);
            }
        }
        
        return answer;
    }
}