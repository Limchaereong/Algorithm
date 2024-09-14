import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int firNum = Integer.parseInt(st.nextToken());
        int secNum = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < firNum; i++){
            String N = br.readLine();
            set.add(N);
        }
        
        for(int i = 0; i < secNum; i++){
            String M = br.readLine();
            if(set.contains(M)){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}