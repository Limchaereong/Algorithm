import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        int total = 0;
        ArrayList<Integer> timeList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int P = Integer.parseInt(st.nextToken());
            timeList.add(P);
        }

        timeList.sort(null);

        for(int i = 0; i < timeList.size(); i++) {
            sum += timeList.get(i);
            total += sum;
        }

        System.out.println(total);
        
    }

}