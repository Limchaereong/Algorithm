import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n1 = Integer.parseInt(inputs[0]);
        int n2 = Integer.parseInt(inputs[1]);

        boolean[] isPrime = new boolean[n2 + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n2; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n2; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = n1; i <= n2; i++) {
            if (isPrime[i]) {
                System.out.println(i + " ");
            }
        }
    }
}