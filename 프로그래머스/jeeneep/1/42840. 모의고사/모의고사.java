import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (pattern[0][i%pattern[0].length] == answers[i]) scores[0]++;
            if (pattern[1][i%pattern[1].length] == answers[i]) scores[1]++;
            if (pattern[2][i%pattern[2].length] == answers[i]) scores[2]++;
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == maxScore) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}