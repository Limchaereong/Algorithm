import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int cnt = 0;

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] isVisited = new boolean[N + 1];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                dfs(i, isVisited, graph);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int node, boolean[] isVisited, ArrayList<Integer>[] graph) {
        isVisited[node] = true;

        for (int neighbor : graph[node]) {
            if(!isVisited[neighbor]) {
                dfs(neighbor, isVisited, graph);
            }
        }
    }

}