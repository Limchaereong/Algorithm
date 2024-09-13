import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            x = x.substring(1, x.length() - 1);
            String[] array = x.split(",");

            List<Integer> arrList = new ArrayList<>();
            if (!x.isEmpty()) {
                for (String element : array) {
                    arrList.add(Integer.parseInt(element.trim()));
                }
            }

            boolean reversed = false;
            boolean error = false;

            for (int j = 0; j < p.length(); j++) {
                char funP = p.charAt(j);

                if (funP == 'R') {
                    reversed = !reversed;
                } else if (funP == 'D') {
                    if (arrList.isEmpty()) {
                        sb.append("error").append("\n");
                        error = true;
                        break;
                    }
                    if (reversed) {
                        arrList.remove(arrList.size() - 1);
                    } else {
                        arrList.remove(0);
                    }
                }
            }

            if (!error) {
                sb.append("[");
                if (reversed) {
                    Collections.reverse(arrList);
                }
                for (int j = 0; j < arrList.size(); j++) {
                    sb.append(arrList.get(j));
                    if (j != arrList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }

        System.out.println(sb);
    }
}