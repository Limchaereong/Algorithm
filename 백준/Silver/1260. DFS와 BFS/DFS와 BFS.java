import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder dfsSb = new StringBuilder();
    private static StringBuilder bfsSb = new StringBuilder();
    
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int trunkCnt = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[nodeCnt + 1];
        for(int i = 1; i <= nodeCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean isVisitedDfs[] = new boolean[nodeCnt + 1];
        boolean isVisitedBfs[] = new boolean[nodeCnt + 1];

        for(int i = 0; i < trunkCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum1 = Integer.parseInt(st.nextToken());
            int nodeNum2 = Integer.parseInt(st.nextToken());

            graph[nodeNum1].add(nodeNum2);
            graph[nodeNum2].add(nodeNum1);
        } // 노드연결 완성

        for(int i = 1; i <= nodeCnt; i++) {
            Collections.sort(graph[i]);
        }

        dfs(startNode, isVisitedDfs, graph);
        System.out.println(dfsSb);

        bfs(startNode, isVisitedBfs, graph);
        System.out.println(bfsSb);

    }

    private static void dfs(int node, boolean[] isVisited, ArrayList<Integer>[] graph) {
        isVisited[node] = true;
        dfsSb.append(node).append(" ");

        for (int neighbor : graph[node]) {
            if(!isVisited[neighbor]) {
                dfs(neighbor, isVisited, graph);
            }
        }
    }

    private static void bfs(int node, boolean[] isVisited, ArrayList<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        isVisited[node] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsSb.append(currentNode).append(" ");

            for (int neighbor : graph[currentNode]) {
                if(!isVisited[neighbor]) {
                    queue.add(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }
    }

}