import java.util.*;

class Car {
    String number;
    int inTime;
    int totalTime;
    String status;
    
    public Car(String number, int inTime){
        this.number = number;
        this.inTime = inTime;
        this.totalTime = 0;
        this.status = "IN";
    }
    
}


class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        TreeMap<String, Car> map = new TreeMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] s = records[i].split(" ");
            String[] t = s[0].split(":");
            
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            String number = s[1];
            String status = s[2];
            
            if(!map.containsKey(number)){
                map.put(number, new Car(number, time));                
            } else if(status.equals("IN")){
                Car car = map.get(number);
                car.inTime = time;
                car.status = "IN";
            } else {
                Car car = map.get(number);
                car.totalTime += time - car.inTime;
                car.status = "OUT";
            }
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        
        for(Car car : map.values()){
            if(car.status.equals("IN")){
                car.totalTime += 23 * 60 + 59 - car.inTime;
            }
            answer[idx++] = calcFee(fees, car.totalTime);
        }
        
        
        return answer;
    }
    
    int calcFee(int[] fees, int time){
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        if(time <= baseTime) return baseFee;
        int extra = (time - baseTime + unitTime - 1) / unitTime;  // 올림
        return baseFee + extra * unitFee;
    }
}