import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Integer> measure;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String in = br.readLine();
            if (in.equals("-1")) {
                break;
            }

            int n = Integer.parseInt(in);

            measure = new ArrayList<>();

            if(isPerfectNum(n)){
                Collections.sort(measure);

                sb.append(n + " = ");
                for(int i = 0; i < measure.size(); i++){
                    sb.append(measure.get(i));
                    
                    if(i < measure.size() -1){
                        sb.append(" + ");
                    }
                }
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.").append("\n");
            }
        }

        System.out.println(sb);

    }

    public static boolean isPerfectNum(int n){
        int sum = 0;

        for(int i = 1; i <= n / 2; i++){
            if(n % i == 0){
                sum += i;
                measure.add(i);
            }
        }
        return sum == n;
    }

}