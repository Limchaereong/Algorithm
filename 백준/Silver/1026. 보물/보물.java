import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> AList = new ArrayList<>();
        ArrayList<Integer> BList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            AList.add(A);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int B = Integer.parseInt(st.nextToken());
            BList.add(B);
        }

        Collections.sort(AList);
        Collections.sort(BList, Comparator.reverseOrder());

        int total = 0;
        for(int i = 0; i < N; i++){
            total += AList.get(i) * BList.get(i);
        }

        System.out.println(total);

    }

}