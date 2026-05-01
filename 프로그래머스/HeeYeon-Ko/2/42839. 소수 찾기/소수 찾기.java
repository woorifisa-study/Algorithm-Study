import java.util.*;

class Solution {
    
    static ArrayList<Integer> list = new ArrayList<>(); // 만들 수 있는 모든 숫자 저장
    static boolean[] visited = new boolean[7]; // numbers 길이 1 이상 7 이하
    
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i = 0; i < numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        
        for(int i = 0; i<list.size(); i++){
            if(isPrime(list.get(i))){
                answer++;
            }
        }
        
        return answer;
    }
    
    // dfs(백트래킹) -> 주어진 str로 m길이의 만들 수 있는 모든 숫자 조합
    // str: 원본 문자열, temp: 현재까지 만든 숫자 문자열, m: 목표 길이
    static void dfs(String str, String temp, int m){
        if(temp.length() == m){
            int num = Integer.parseInt(temp);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        
        for(int i=0; i<str.length();i++){
            if(!visited[i]){
                visited[i] = true;
                temp += str.charAt(i); // 문자 추가
                dfs(str, temp, m);     // 재귀
                
                // 되돌리기
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
        
    }
    
    // 소수인지 판단
    static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        
        for(int i = 2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        
        return true;
    }
}