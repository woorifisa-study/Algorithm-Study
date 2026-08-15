import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        
        int count1=0;
        int count2=0;
        int count3=0;
        
        // answers의 배열 길이만큼만 비교하면 된다
        for(int i=0; i<answers.length; i++) {
            if(num1[i%5] == answers[i]) count1++;
            if(num2[i%8] == answers[i]) count2++;
            if(num3[i%10] == answers[i]) count3++;
        }
        
        int max = Math.max(count1, Math.max(count2, count3));
        
        ArrayList<Integer> result = new ArrayList<>();
        if(count1 == max) result.add(1);
        if(count2 == max) result.add(2); // 중복 고려
        if(count3 == max) result.add(3);
        
        int[] answer = new int[result.size()]; // arraylist는 length 불가
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i); // arraylist 받기(배열이 아님)
        }
        return answer;
        
    }
}