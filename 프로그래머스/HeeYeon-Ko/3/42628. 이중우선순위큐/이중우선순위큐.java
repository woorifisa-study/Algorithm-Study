import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        
        for(String operation : operations){
            String[] arr = operation.split(" ");
            String order = arr[0]; // 명령어
            int num = Integer.parseInt(arr[1]); // 숫자
            
            if(order.equals("I")){
                minHeap.offer(num);
                maxHeap.offer(num);
            }
            else if(!maxHeap.isEmpty() && order.equals("D") && num == 1){
                int max = maxHeap.remove();
                minHeap.remove(max);
            }
            else if(!minHeap.isEmpty() && order.equals("D") && num == -1){
                int min = minHeap.remove();
                maxHeap.remove(min);
            }
        }
        
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
    
    
}