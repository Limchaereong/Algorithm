import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String loseParentheses = br.readLine();

        int sum = 0;

        if(loseParentheses.contains("-")){
            StringTokenizer minusToken = new StringTokenizer(loseParentheses, "-");

            sum += calculatePlus(minusToken.nextToken());

            while (minusToken.hasMoreElements()) {
                sum -= calculatePlus(minusToken.nextToken());
            }

        } else {
            sum = calculatePlus(loseParentheses);
        }

        System.out.println(sum);
        
    }

    private static int calculatePlus(String exp) {
        StringTokenizer plusToken = new StringTokenizer(exp, "+");
        int sum = 0;

        while (plusToken.hasMoreTokens()) {
            sum += Integer.parseInt(plusToken.nextToken());
        }
        return sum;        
    }

}