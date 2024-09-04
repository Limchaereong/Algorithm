import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> hearSet = new HashSet<>();
        Set<String> seeSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hearSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            seeSet.add(br.readLine());
        }

        hearSet.retainAll(seeSet);

        List<String> result = new ArrayList<>(hearSet);
        Collections.sort(result);

        System.out.println(result.size());
        for (String person : result) {
            System.out.println(person);
        }

    }
}
