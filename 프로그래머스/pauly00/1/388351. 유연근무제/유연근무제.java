class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int award = schedules.length;
        
        // 일주일 단위
        int member=0; // 직원 번호
        for(member=0; member<schedules.length; member++){
            // 희망시각 시, 분 분리
            int hour = schedules[member] / 100;
            int minute = schedules[member] % 100;
            int limit = hour * 60 + minute + 10;
            
            for(int i=0; i<7; i++) {
                // 실제 출근 시간 시, 분 분리
                int log = timelogs[member][i];
                int loghour = log/100;
                int logminute = log%100;
                int logtime = loghour*60 + logminute;
                
                // 주말은 continue
                int currentday = (startday +i) %7; // 일요일부터 시작
                if(currentday == 6 || currentday == 0) continue;
                
                // 10분이 넘어가면 미션 실패
                else if(limit < logtime) {
                    award--;
                    break;
                }
            }
        }
        
        return award;
    }
}