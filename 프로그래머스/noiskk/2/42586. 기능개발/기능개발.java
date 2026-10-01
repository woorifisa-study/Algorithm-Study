import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] left = new int[progresses.length];
        
        for(int i = 0; i < left.length; i++){
            left[i] = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
        }
        
        int num = left[0];
        int count = 1;
        
        for(int i = 1; i < left.length; i++){
            if(left[i] <= num) count++;
            else{
                list.add(count);
                count = 1;
                num = left[i];
            } 
        }
        
        list.add(count);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}