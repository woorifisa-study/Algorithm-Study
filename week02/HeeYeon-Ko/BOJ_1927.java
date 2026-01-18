import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());

            if(num > 0){
                priorityQueue.add(num);
            }
            else{
                if(!priorityQueue.isEmpty()){
                    System.out.println(priorityQueue.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }

}

