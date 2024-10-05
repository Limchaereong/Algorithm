import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, K;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            isVisited = new boolean[N][M];

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            } //입력받은대로 배추밭에 배추를 1로 표시

            int wormCnt = 0;

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if (board[j][k] == 1 && !isVisited[j][k]) {
                        dfs(j, k);
                        wormCnt++;
                    }
                }
            }

            System.out.println(wormCnt);

        }
    
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < N && newY >= 0 && newY < M) {
                if(board[newX][newY] == 1 && !isVisited[newX][newY]) {
                    dfs(newX, newY);
                }
            }

        }
    }

}