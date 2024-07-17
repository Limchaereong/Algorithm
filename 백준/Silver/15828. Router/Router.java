import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int bufferSize = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            String inPacket = br.readLine();
            int packet = Integer.parseInt(inPacket);

            if(packet == -1){
                break;
            } else if(packet == 0){
                if(!queue.isEmpty()){
                    queue.poll();
                }
            } 
            else {
                if(queue.size() < bufferSize){
                    queue.offer(packet);
                }
            }
        }
        
        if(queue.isEmpty()){
            sb.append("empty");
        } else {
            while (!queue.isEmpty()){
                sb.append(queue.poll()).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
