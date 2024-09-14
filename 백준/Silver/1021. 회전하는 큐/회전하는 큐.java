import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static final Deque<Integer> deque = new LinkedList<>();
    static int totalCnt = 0;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int targetCnt = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < targetCnt; i++){
            int targetPosition = Integer.parseInt(st.nextToken());

            while (true) {
                if(deque.peekFirst() == targetPosition){
                    deque.pollFirst();
                    break;
                } else {
                    int leftShift = findLeftShifts(targetPosition);
                    int rightShift = deque.size() - leftShift;

                    if(leftShift <= rightShift){
                        leftShift();
                    } else {
                        rightShift();
                    }
                }
            }
        }

        System.out.println(totalCnt);

    }

    public static void leftShift(){
        deque.addLast(deque.pollFirst());
        totalCnt++;
    }

    public static void rightShift(){
        deque.addFirst(deque.pollLast());
        totalCnt++;
    }

    public static int findLeftShifts(int targetPosition) {
        int count = 0;
        for (int num : deque) {
            if (num == targetPosition) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

}