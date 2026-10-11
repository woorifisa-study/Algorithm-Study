import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 배포 기준날짜(첫번째 기능 완료)
        int deploy = (100-progresses[0] + speeds[0] -1) / speeds[0];
        int count =1; // 배포 기능개수
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=1; i<progresses.length; i++) {
            // 소수점문제(speeds[i]-1)
            int day = (100-progresses[i] + speeds[i] -1) / speeds[i];
            
            // 배포기준일 전에 완료 시
            if(day <=deploy) count++;
            else{
                result.add(count); // 기존 배포 그룹의 기능 개수 저장
                deploy=day; // 새로운 배포 기준일
                count=1;
            }
        }
        
        result.add(count);
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
        
    }
}