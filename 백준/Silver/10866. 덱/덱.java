import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    int frontValue = Integer.parseInt(st.nextToken());
                    deque.offerFirst(frontValue);
                    break;

                case "push_back":
                    int backValue = Integer.parseInt(st.nextToken());
                    deque.offerLast(backValue);
                    break;

                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;

                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;

                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.getFirst()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;

                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.getLast()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}
