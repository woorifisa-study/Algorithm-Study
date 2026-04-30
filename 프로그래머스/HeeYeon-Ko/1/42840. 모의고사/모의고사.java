import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int size = answers.length;
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answer1 = new int[size]; // 1번 수포자
        int[] answer2 = new int[size]; // 2번 수포자
        int[] answer3 = new int[size]; // 3번 수포자
        int[] count = new int[3]; 
        
        
        for(int i = 0; i < size ; i++){
            // 1번 수포자
            answer1[i] = pattern1[i%5];
            if(answer1[i] == answers[i]){
                count[0]++;
            }
            // 2번 수포자
            answer2[i] = pattern2[i%8];
            if(answer2[i] == answers[i]){
                count[1]++;
            }
            // 3번 수포자
            answer3[i] = pattern3[i%10];
            if(answer3[i] == answers[i]){
                count[2]++;
            }
        }

        int maxScore = Math.max(count[0], Math.max(count[1], count[2]));
        
        List<Integer> correct = new ArrayList<>();
        
        for(int i = 0 ; i < 3; i++){
            if(maxScore == count[i]){
                correct.add(i + 1);
            }
        }
        
        int[] result = new int[correct.size()];
        for(int i = 0; i < correct.size(); i++){
            result[i] = correct.get(i);
        }
        return result;
     
    }
}