// 금요일
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 앞으로 reader(input)만 포함    
        String input = br.readLine();

        // string문 공백 기준으로 나눔
        String[] input_split = input.split(" ");
        int n = Integer.parseInt(input_split[0]);
        int k = Integer.parseInt(input_split[1]);
        
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>(); // 배열 말고 큐 사용
        for(int i=0; i<n; i++) q.add(i+1); // 큐 푸시

        int tmp1=0; // 결과값 배열
        int out = 0; // 꺼낸 순서
        while(!q.isEmpty()) {
            int current = q.poll(); // 꺼내고
            out++;
            if(out==k){ // 순서가 k번째가 되면
                ans[tmp1]= current; // 배열 삽입
                tmp1++;
                out=0;
            }
            else {
                q.add(current);
            }
        }

        System.out.print("<");
        // 나머지 출력값
        for(int i=0; i<n-1; i++) { 
            System.out.print(ans[i] + ", ");
        }
        System.out.print(ans[n-1]+">");
    }
}