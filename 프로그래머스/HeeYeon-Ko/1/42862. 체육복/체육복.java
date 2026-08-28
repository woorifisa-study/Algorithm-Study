import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        
        // 도난당한 학생
        for(int l : lost){
            students[l]--;
        }
        
        // 여벌의 체육복 가져온 학생
        for(int r : reserve){
            students[r]++;
        }
        
        for(int i = 1; i <= n; i++){
            if(students[i] == 2){
                // 왼쪽 학생부터 확인
                if(i-1 >= 1 && students[i-1] == 0){
                    students[i-1]++;
                    students[i]--;
                }
                // 오른쪽 학생 확인
                else if(i+1 <= n && students[i+1] == 0){
                    students[i+1]++;
                    students[i]--;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(students[i] > 0){
                answer++;
            }
        }
        
        return answer;
    }
}