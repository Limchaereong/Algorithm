import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static boolean[] isSelect;
    public static int[] selectedNum;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelect = new boolean[N + 1];
        selectedNum = new int[M];

        backtrack(0);
        
        System.out.println(sb);

    }

    public static void backtrack(int depth){

        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(selectedNum[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!isSelect[i]){
                isSelect[i] = true;
                selectedNum[depth] = i;
                backtrack(depth + 1);
                isSelect[i] = false;
            }
        }

    }

}