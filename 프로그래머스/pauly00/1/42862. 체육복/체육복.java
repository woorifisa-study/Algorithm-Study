import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = n-lost.length;
        // 예외케이스 있어서 정렬 후 진행
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌이 도난당했을 때(lost = reverse)
        // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
        
        // 겹치는 학생
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) { // 겹침
                    count++; // 겹치는 인원은 카운트 증가
                    lost[i]=-1;
                    reserve[j]=-1;
                    break; // 찾으면 reserve의 for문은 제거해도 됨
                }
            }
        }
        
        // 빌리는 로직(겹치는 케이스 끝나고 새로 배열에 넣어야됨)
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                // 절대값(+-1 차이)
                if(Math.abs(lost[i] - reserve[j]) == 1){
                    count++; 
                    lost[i] = -1; // 받음
                    reserve[j] = -1; // 이미 빌려줌
                    break; // 이미 빌려줬으므로 reserve의 for문 제거
                }
            }
        }
        
        return count;
    }
}