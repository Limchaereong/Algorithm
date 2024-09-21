import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int C = Integer.parseInt(br.readLine());

            int quarterCnt = C / 25;
            C %= 25;

            int dimeCnt = (C % 25) / 10;
            C %= 10;

            int nickelCnt = (C % 10) / 5;
            C %= 5;

            int pennyCnt = (C % 5) / 1;
            
            sb.append(quarterCnt + " ").append(dimeCnt + " ").append(nickelCnt + " ").append(pennyCnt).append("\n");

        }

        System.out.println(sb);

    }

}