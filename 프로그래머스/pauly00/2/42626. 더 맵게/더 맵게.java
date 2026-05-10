import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for(int array: scoville) {
            pq.add(array);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            
            int newFood = first + (second*2);
            
            pq.add(newFood);
            
            count++;
        }
        
        return count;
    }
}