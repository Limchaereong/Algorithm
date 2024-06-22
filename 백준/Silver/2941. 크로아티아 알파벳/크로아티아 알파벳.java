import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String text = bufferedReader.readLine();

        int cnt = 0;
        int idx = 0;
        String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        while (idx < text.length()) {
            boolean matched = false;
            for (String c : croatian) {
                if (idx + c.length() <= text.length() &&
                        text.substring(idx, idx + c.length()).equals(c)) {
                    idx += c.length();
                    matched = true;
                    break;
                }
            }
            if(!matched){
                idx++;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
