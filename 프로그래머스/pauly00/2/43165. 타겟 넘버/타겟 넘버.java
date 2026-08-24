class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        // 모든 경우의 수 작성 후 타겟과 동일한지, 동일하면 카운트 추가
        DFS(numbers, target, 0, 0);
        return count;
    }
    
    public void DFS(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) { // numbers배열과 깊이가 동일할 때만
            // sum과 target 비교
            if(sum == target) count++;
            
            return;
        }
        
        // 현재숫자 (+)
        DFS(numbers, target, depth+1, sum+numbers[depth]);
        // 현재숫자 (-)
        DFS(numbers, target, depth+1, sum-numbers[depth]);
    }
}