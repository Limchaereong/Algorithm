import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int currentNum = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (currentNum <= num) {
                stack.push(currentNum);
                sb.append("+\n");
                currentNum++;
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

    }
}
