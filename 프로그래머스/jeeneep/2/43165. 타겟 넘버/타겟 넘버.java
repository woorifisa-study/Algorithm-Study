class Solution {

    static int answer;
    
    public int solution(int[] numbers, int target) {
        
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int index, int sum) {
        // 탈출 조건: 모든 숫자를 다 사용했는지 확인
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        // 다음 숫자를 더하는 경우의 호출 
        dfs(numbers, target, index + 1, sum + numbers[index]);
        // 다음 숫자를 빼는 경우의 호출
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}