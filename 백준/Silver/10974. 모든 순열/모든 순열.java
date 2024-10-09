import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] isVisited;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];
        numbers = new int[N];

        sb = new StringBuilder();

        recursive(0);

        System.out.println(sb.toString());

    }

    private static void recursive(int depth) {
        if(depth == N) {
            for(int i = 0; i < N; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for(int i = 1; i <= N; i++) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    numbers[depth] = i;
                    recursive(depth + 1);
                    isVisited[i] = false;
                }
            }
        }
    }

}