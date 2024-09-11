import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int X = Integer.parseInt(br.readLine());

            if(X == 0){
                if(priorityQueue.size() == 0){
                    sb.append("0").append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(X);
            }
        }

        System.out.println(sb);

    }
}
