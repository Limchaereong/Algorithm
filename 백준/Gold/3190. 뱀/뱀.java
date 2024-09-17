import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Object[]> directChange = new LinkedList<>();
        for(int i = 0; i < L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
        
            directChange.add(new Object[]{X, C});
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1,1});
        board[1][1] = 2;

        int time = 0;
        int direct = 0;
        while (true) {
            time++;

            int[] snakeHead = snake.peekFirst();
            int newX = snakeHead[0] + dx[direct];
            int newY = snakeHead[1] + dy[direct];

            if(newX < 1 || newY < 1 || newX > N || newY > N || board[newX][newY] == 2){
                break;
            }

            if(board[newX][newY] == 1){
                board[newX][newY] = 2;
                snake.addFirst(new int[]{newX, newY});
            } else {
                board[newX][newY] = 2;
                snake.addFirst(new int[]{newX, newY});
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (!directChange.isEmpty() && (int)directChange.peek()[0] == time) {
                Object[] change = directChange.poll();
                if ((char)change[1] == 'L') {
                    direct = (direct + 3) % 4;
                } else if ((char)change[1] == 'D') {
                    direct = (direct + 1) % 4;
                }
            }
        }

        System.out.println(time);

    }

}