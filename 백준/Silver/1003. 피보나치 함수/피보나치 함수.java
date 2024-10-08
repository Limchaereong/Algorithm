import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] count0 = new int[41];
        int[] count1 = new int[41];

        count0[0] = 1;
        count1[0] = 0;
        count0[1] = 0;
        count1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(count0[N] + " " + count1[N]);
        }
    }
}
