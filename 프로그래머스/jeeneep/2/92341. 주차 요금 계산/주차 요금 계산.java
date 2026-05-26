import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
            
        // 입차 확인용 map
        Map<String, Integer> inTimeMap = new HashMap<>();
        
        // total 주차 시간 저장용 map
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        StringTokenizer st;
        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            
            String time = st.nextToken();            
            int calculatedTime = convertToMinutes(time);

            String carNum = st.nextToken();
            String type = st.nextToken();
            
            // 입차인 경우
            if (type.equals("IN")) {
                inTimeMap.put(carNum, calculatedTime);
            } 
            // 출차인 경우
            else {
                int outTime = calculatedTime;
                int inTime = inTimeMap.remove(carNum);
                
                int duration = outTime - inTime;
                
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + duration);
            }
            
        }
        
        // 출차하지 않은 차가 존재하는 경우
        List<String> inCars = new ArrayList<>(inTimeMap.keySet());
        for (String carNum : inCars) {
            int outTime = 23 * 60 + 59;
            int inTime = inTimeMap.remove(carNum);
            
            int duration = outTime - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + duration);
        }
        
        
        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        int index = 0;
        
        // 주차 요금 계산
        for (String carNum : carNumbers) {
            int time = totalTimeMap.get(carNum);
            
            // 기본 시간 이하
            if (time <= fees[0]) {
                answer[index++] = fees[1];
            }
            else {
                int exceed = time - fees[0];
                int extraFee = (int) Math.ceil( (double) exceed / fees[2]) * fees[3];
                
                answer[index++] = fees[1] + extraFee;
            }
        }
        
        return answer;
    }
    
    static int convertToMinutes(String time) {
        
        String parts[] = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        
        return hour * 60 + min;
    }
}