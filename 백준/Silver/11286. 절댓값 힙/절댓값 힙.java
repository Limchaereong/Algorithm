import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2){
                int absCompare = Integer.compare(Math.abs(n1), Math.abs(n2));
                if(absCompare == 0){
                    return Integer.compare(n1, n2);
                }
                return absCompare;
            }
        });

        for(int i = 0; i < N; i++){
            int X = Integer.parseInt(br.readLine());

            if(X == 0){
                if(absQueue.isEmpty()){
                    sb.append("0").append("\n");
                } else {
                    sb.append(absQueue.poll()).append("\n");
                }
            } else {
                absQueue.add(X);
            }
        }
        System.out.println(sb);
    }
}
