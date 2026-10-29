class Solution {
    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, target, numbers);
        
        return count;
    }
    
    void dfs(int depth, int result, int target, int[] numbers){
        if(depth == numbers.length){
            if(result == target){
                count++;   
            }
        }
        
        if(depth < numbers.length){
            dfs(depth+1, result - numbers[depth], target, numbers);
            dfs(depth+1, result + numbers[depth], target, numbers);
        }
        
    }
}