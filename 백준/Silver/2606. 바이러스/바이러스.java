import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int nodeCnt = Integer.parseInt(br.readLine());
        int nodePairCnt = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[nodeCnt + 1];
        for(int i = 1; i <= nodeCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[nodeCnt + 1];
        
        for(int i = 0; i < nodePairCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int trunk1 = Integer.parseInt(st.nextToken());
            int trunk2 = Integer.parseInt(st.nextToken());

            graph[trunk1].add(trunk2);
            graph[trunk2].add(trunk1);
        } // 노드 완성

        int result = dfs(1, graph, visited) - 1;

        System.out.println(result);

    }

    private static int dfs(int node, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;

        for (int neighbor : graph[node]) {
            if(!visited[neighbor]) {
                cnt += dfs(neighbor, graph, visited);
            }            
        }

        return cnt;

    }

}