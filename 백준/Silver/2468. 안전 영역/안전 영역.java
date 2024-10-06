import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        isVisited = new boolean[N][N];

        int maxHeight = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        } // 지역 높이에 따른 보드 완성

        int maxSafeAreaCnt = 0;

        for(int heigth = 0; heigth <= maxHeight; heigth++) {
            isVisited = new boolean[N][N];
            int safeAreaCnt = 0;

            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < N; j++) {
                    if(!isVisited[i][j] && board[i][j] > heigth) {
                        dfs(i, j, heigth);
                        safeAreaCnt++;
                    }
                }
            }

            maxSafeAreaCnt = Math.max(maxSafeAreaCnt, safeAreaCnt);

        }

        System.out.println(maxSafeAreaCnt);

    }

    private static void dfs(int x, int y,int heigth) {
        isVisited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < N && newY >= 0 && newY < N) {
                if(!isVisited[newX][newY] && board[newX][newY] > heigth) {
                    dfs(newX, newY, heigth);
                }
            }
        }
    }

}