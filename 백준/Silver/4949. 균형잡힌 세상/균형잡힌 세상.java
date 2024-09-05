import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String sentence = br.readLine();

            if (sentence.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.print(sb);
    }
}