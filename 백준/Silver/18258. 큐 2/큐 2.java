import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main Main = new Main();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    Main.push(value);
                    break;
                
                case "pop":
                    Main.pop();
                    break;

                case "size":
                    Main.size();
                    break;

                case "empty":
                    Main.empty();
                    break;

                case "front":
                    Main.front();
                    break;

                case "back":
                    Main.back();
                    break;
            }
        }

        System.out.println(Main.sb);

    }

    public void push(int X){
        queue.offer(X);
    }

    public void pop(){
        if(queue.size() == 0){
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.poll()).append("\n");
        }
    }

    public void size(){
        sb.append(queue.size()).append("\n");
    }

    public void empty(){
        if(queue.size() == 0){
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    public void front(){
        if(queue.size() == 0){
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.peek()).append("\n");
        }
    }

    public void back(){
        if(queue.size() == 0){
            sb.append("-1").append("\n");
        } else {
            sb.append(((LinkedList<Integer>) queue).getLast()).append("\n");
        }
    }

}
