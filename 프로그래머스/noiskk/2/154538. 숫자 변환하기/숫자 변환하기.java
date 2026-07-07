import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        if(x == y) return 0;
        
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        visited.add(x);
        queue.offer(x);
        
        int count = 0;
        boolean complete = false;
        
        outer:
        while(!queue.isEmpty()){
            count++;
            
            int size = queue.size(); // 현재 레벨의 원소 개수
            
            for(int i = 0; i < size; i++){
                int num = queue.poll();
            
                // y 변환 성공
                if (num * 2 == y || num * 3 == y || num + n == y) {
                    complete = true;
                    break outer;
                }
            
                if(num * 2 < y && !visited.contains(num * 2)) {
                    visited.add(num * 2);
                    queue.offer(num * 2);
                }
                
                if(num * 3 < y && !visited.contains(num * 3)) {
                    visited.add(num * 3);
                    queue.offer(num * 3);
                }
                
                if(num + n < y && !visited.contains(num + n)) {
                    visited.add(num + n);
                    queue.offer(num + n);
                }
            }
   
        }
        
        return complete ? count : -1;
         
    }
}