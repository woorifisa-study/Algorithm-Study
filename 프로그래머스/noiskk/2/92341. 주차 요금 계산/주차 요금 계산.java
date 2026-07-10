import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        for(String record : records){
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            String type = parts[2];
            
            String[] hm = time.split(":");
            int minutes = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            
            if(type.equals("IN")){
                inTimeMap.put(car, minutes);
            } else {
                int inTime = inTimeMap.remove(car);
                int parkingTime = minutes - inTime;
                totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + parkingTime);   
            }
        }
        
        // 끝까지 OUT 안 한 차량
        for(Map.Entry<String, Integer> entry : inTimeMap.entrySet()){
            int usage = 23 * 60 + 59 - entry.getValue();
            totalTimeMap.put(entry.getKey(), totalTimeMap.getOrDefault(entry.getKey(), 0) + usage);
        }
    
        List<String> cars = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(cars);
        
        List<Integer> answer = new ArrayList<>();
        for(String car : cars){
            answer.add(calculateFee(fees, totalTimeMap.get(car)));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int calculateFee(int[] fees, int time){
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(time <= basicTime) return basicFee;
        
        int extra = time - basicTime;
        int unit = (int) Math.ceil((double) extra / unitTime);

        return basicFee + unit * unitFee;
    }
}