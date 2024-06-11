import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int cnt = N;
            for (int i = 0; i < N; i++) {
                String word = br.readLine();

                int prev = 0;
                int[] alphabet = new int[26];

                for (int j = 0; j < word.length(); j++) {
                    int now = word.charAt(j);

                    if (prev != now) {
                        if (alphabet[now - 97] == 0) {
                            alphabet[now - 97]++;
                            prev = now;
                        } else {
                            cnt--;
                            break;
                        }
                    }

                }
            }
            System.out.println(cnt);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}