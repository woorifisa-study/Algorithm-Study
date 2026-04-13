import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.offerLast(new int[]{i, priorities[i]}); // {location, priority}
        }
        
        int count = 0;
        int result = 0;
        
        while(true){
            int[] current = queue.pollFirst();
            boolean isValid = true;
            
            for(int[] inQueue : queue){
                if(current[1] < inQueue[1]){
                    queue.offerLast(current);
                    isValid = false;
                    break;
                }
            }
            
            if(isValid){
                count++;
                
                if(current[0] == location){
                    result = count;
                    break;
                }
            }
            
        }
        
        return result;
        
    }
}