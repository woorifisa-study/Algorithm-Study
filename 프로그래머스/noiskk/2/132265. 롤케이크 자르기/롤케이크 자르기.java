import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        for(int t : topping){
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        int answer = 0;
        
        for(int i = 0; i < topping.length - 1; i++){
            
            int t = topping[i];
            
            int count = rightMap.get(t) - 1;
            if(count == 0){
                rightMap.remove(t);
            } else {
                rightMap.put(t, count);
            }
            
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);
            
            if(leftMap.size() == rightMap.size()){
                answer++;
            }
        }
        
        return answer;

    }
}