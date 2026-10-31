import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        
        for(int i = 0; i < A.length/2; i++){
            int tmp = A[i];
            A[i] = A[A.length-i-1];
            A[A.length-i-1] = tmp;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < B.length; i++){
            queue.add(B[i]);
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] < queue.peek()){
                answer++;
                queue.poll();
            }
        }
        
        return answer;
    }
}