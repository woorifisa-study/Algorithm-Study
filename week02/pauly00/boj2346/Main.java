import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] paper = new int[n]; // 풍선 안의 종이

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n;i++) dq.add(i+1);
        String[] inputStr = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            paper[i] = Integer.parseInt(inputStr[i]);
        }
        // 1158번과 유사
        int[] ans = new int[n];

        ans[0] = dq.pollFirst(); // 첫 값
        int tmp; // 초기값
        for(int i=1; i<n; i++) {
            tmp=paper[ans[i-1]-1]; // 이동횟수

            while(tmp>1 || tmp<0){ // pollFirst 효과 때문
                if(tmp>0){
                    dq.addLast(dq.pollFirst()); // 맨뒤로 이동
                    tmp--;
                }
                else if(tmp<0) {
                    dq.addFirst(dq.pollLast()); // 맨앞으로 이동
                    tmp++;
                }
            }
            ans[i] = dq.pollFirst();
        }

        // -일때(왼쪽)
        for (int i = 0; i < n-1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print(ans[n-1]);
    }
}