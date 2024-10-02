import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        
        for(int i = 0 ; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        } // 노드 그리기 완성

        dfs(1);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }

    private static void dfs(int node) {
        isVisited[node] = true;

        for (int neighbor : graph[node]) {
            if(!isVisited[neighbor]) {
                parent[neighbor] = node;
                dfs(neighbor);
            }
        }
    }

}