import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 1; i <= N; i++) {
            if(recursive(i)) {
                result ++;
            }
        }

        System.out.println(result);
        
    }

    private static boolean recursive(int num) {
        if(num < 100) {
            return true;
        } else {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            return (a - b) == (b - c);
        }
    }

}