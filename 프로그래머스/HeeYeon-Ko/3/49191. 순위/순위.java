class Solution {
    public int solution(int n, int[][] results) {
        
        int answer = n;
        
        int[][] graph = new int[n+1][n+1];
        
        for(int[] result : results){
            graph[result[0]][result[1]] = 1;  // result[0]이 result[1]을 이김
            graph[result[1]][result[0]] = -1; // result[1]이 result[0]에게 짐
        }
        
        for(int mid = 1; mid <= n; mid++){
            for(int start = 1; start <= n; start++){
                for(int end = 1; end <= n; end++){
                    if(graph[start][end] != 0) continue;
                    if(graph[start][mid] == 1 && graph[mid][end] == 1){
                        graph[start][end] = 1;
                        graph[end][start] = -1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j) continue;
                if(graph[i][j] == 0){
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}