import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < N; j++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{j, importance});
                priorityQueue.offer(importance);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[1] == priorityQueue.peek()) {
                    printOrder++;
                    priorityQueue.poll();

                    if (current[0] == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
