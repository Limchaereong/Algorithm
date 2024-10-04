import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int M,N,K;
    static boolean[][] isVisited;
    static int[][] board;
    static ArrayList<Integer> area = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());

            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int y = leftY; y < rightY; y++) {
                for(int x = leftX; x < rightX; x++) {
                    board[y][x] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0 && !isVisited[i][j]) {
                    int areaSize = dfs(i, j);
                    area.add(areaSize);
                }
            }
        }

        Collections.sort(area);
        System.out.println(area.size());
        for (int size : area) {
            System.out.print(size + " ");
        }

    }

    private static int dfs(int row, int col) {
        int areaSize = 1;
        isVisited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newRow < M && newCol >= 0 && newCol < N) {
                if(board[newRow][newCol] == 0 && !isVisited[newRow][newCol]) {
                    areaSize += dfs(newRow, newCol);
                }
            }
        }

        return areaSize;

    }

}