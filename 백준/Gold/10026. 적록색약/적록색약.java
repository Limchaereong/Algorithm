import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char line;
    static char[][] board;
    static char[][] blindnessBoard;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        blindnessBoard = new char[N][N];
        isVisited= new boolean[N][N];

        for(int i = 0; i < N; i ++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                char color = line.charAt(j);
                board[i][j] = color;

                if(color == 'G') {
                    blindnessBoard[i][j] = 'R';
                } else {
                    blindnessBoard[i][j] = color;
                }
            }
        }

        int regoinCnt = 0;
        isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j, board, board[i][j]);
                    regoinCnt++;
                }
            }
        }

        int blindNessRegoinCnt = 0;
        isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j, blindnessBoard, blindnessBoard[i][j]);
                    blindNessRegoinCnt++;
                }
            }
        }

        System.out.println(regoinCnt + " " + blindNessRegoinCnt);
        
    }

    private static void dfs(int x, int y, char[][] board, char color) {
        isVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < N && newY >= 0 && newY < N) {
                if(!isVisited[newX][newY] && board[newX][newY] == color) {
                    dfs(newX, newY, board, color);
                }
            }
        }
    }

}