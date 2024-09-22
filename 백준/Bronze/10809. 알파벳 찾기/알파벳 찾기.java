import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int[] inIdx = new int[26];

        for(int i = 0; i < 26; i++) {
            inIdx[i] = -1;
        }

        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int outIdx = ch - 'a';

            if(inIdx[outIdx] == -1) {
                inIdx[outIdx] = i;
            }
        }

        for(int i = 0; i < 26; i++) {
            sb.append(inIdx[i]).append(" ");
        }

        System.out.println(sb);
        
    }

}