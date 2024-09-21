import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
         * A = 300
         * B = 60
         * C = 10
         */

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();

         int cookTime = Integer.parseInt(br.readLine());

         if(cookTime % 10 != 0) {

            sb.append(-1);

         } else {

            int ACnt = cookTime / 300;
            cookTime %= 300;
   
            int BCnt = cookTime / 60;
            cookTime %= 60;
   
            int CCnt = cookTime / 10;
   
            sb.append(ACnt + " ").append(BCnt + " ").append(CCnt);

         }
         
         System.out.println(sb);

    }

}