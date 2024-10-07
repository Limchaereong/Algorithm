import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int W, H;
    static boolean[][] isVisited;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) {
                break;
            }

            board = new int[H][W];
            isVisited = new boolean[H][W];

            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            } //보드 완성

            cnt = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(board[i][j] == 1 && !isVisited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");

        }
        
        System.out.println(sb);
    
    }

    public static void dfs(int x, int y) {

        isVisited[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < H && newY >= 0 && newY < W) {
                if(!isVisited[newX][newY] && board[newX][newY] == 1) {
                    dfs(newX, newY);
                }
            }
        }
    }

}