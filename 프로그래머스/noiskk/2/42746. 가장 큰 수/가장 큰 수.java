import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 문자열로 변환 후
        // 커스텀 정렬하기
        
        String[] strNumbers = new String[numbers.length];   
        
        for(int i = 0; i < numbers.length; i++){
            strNumbers[i] = numbers[i] + "";
        }
    
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(strNumbers[0].equals("0")) return "0";
    
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < strNumbers.length; i++){
            result.append(strNumbers[i]);
        }
        
        
        return result.toString();
    }
}