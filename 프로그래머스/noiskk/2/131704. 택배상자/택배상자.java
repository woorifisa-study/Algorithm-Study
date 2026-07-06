import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        int truck = 0;  // 트럭에 실린 개수
        int targetIndex = 0; // 다음에 실어야 할 상자 인덱스
        
        for(int belt = 1; belt <= order.length; belt++){
            
            if(belt == order[targetIndex]){
                truck++;
                targetIndex++;
                
                while(!stack.isEmpty() && stack.peek() == order[targetIndex]){
                    stack.pop();
                    truck++;
                    targetIndex++;
                }
            } else {
                stack.push(belt);
            }
        }
        
        return truck;
    }
}

