import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.print.DocFlavor.INPUT_STREAM;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> maxCards = new ArrayList<>();

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {

                    int cardSum = cards[i] + cards[j] + cards[k];

                    if(cardSum <= M) {
                        maxCards.add(cardSum);
                    }
                }
            }
        }

        Collections.sort(maxCards, Comparator.reverseOrder());
        System.out.println(maxCards.get(0));
           
    }

}