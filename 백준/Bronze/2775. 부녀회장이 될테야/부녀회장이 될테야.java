import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] live = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            live[0][i] = i;
        }

        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                live[k][n] = live[k][n - 1] + live[k - 1][n];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(live[k][n]);
        }
    }
}
