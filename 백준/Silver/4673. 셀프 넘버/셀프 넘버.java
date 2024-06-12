import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean[] isGenerated = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int dn = d(i);
            if (dn <= 10000) {
                isGenerated[dn] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isGenerated[i]) {
                System.out.println(i);
            }
        }

    }

    private static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
