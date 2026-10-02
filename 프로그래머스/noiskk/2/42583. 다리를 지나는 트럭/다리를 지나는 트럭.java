import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<int[]> queue = new ArrayDeque();
        
        int sum = truck_weights[0];
        int time = 1;
        int next = 1; // 트럭 인덱스
        
        queue.offer(new int[]{truck_weights[0], time});
        
        while(!queue.isEmpty() && next < truck_weights.length){
            
            time++;
            
            // 다리를 다 건던 트럭 계산
            // 마지막 트럭이 올라간 시간 <= (현재 시간 - 다리 길이)
            if(queue.peek()[1] <= time - bridge_length){
                sum -= queue.poll()[0];
            }

            // 다리에 올라갈 수 있는지 확인 후 올라감
            if(sum + truck_weights[next] <= weight){
                sum += truck_weights[next];
                queue.offer(new int[]{truck_weights[next], time});
                next++;
            }
        }
        
        while(!queue.isEmpty()){
            time++;
            if(queue.peek()[1] <= time - bridge_length){
                queue.poll();
            }
        }
        
        return time;
    }
}