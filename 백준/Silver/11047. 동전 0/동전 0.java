import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> AList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            AList.add(A);
        }

        Collections.sort(AList, Comparator.reverseOrder());
        int coinCnt = 0;

        for(int i = 0; i < N; i++) {
            if(AList.get(i) <= K) {
                coinCnt += K / AList.get(i);
                K %= AList.get(i);
            }
        }
        

        System.out.println(coinCnt);
                
    }

}