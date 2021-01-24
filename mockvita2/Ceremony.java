import java.io.*;
import java.util.*;

public class Ceremony {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    String brides = br.readLine();
    String grooms = br.readLine();
    char brides_arr[] = brides.toCharArray();
    char grooms_arr[] = grooms.toCharArray();

    Queue<Character> brides_queue = new LinkedList<Character>();
    Queue<Character> grooms_queue = new LinkedList<Character>();

    for(int i = 0 ; i < n ; i++) {
      brides_queue.add(brides_arr[i]);
      grooms_queue.add(grooms_arr[i]);
    }

    boolean flag = true;

    while(flag) {
      flag = false;
      for(int i = 0 ; i < brides_queue.size() ; i++) {
        if(brides_queue.peek() == grooms_queue.peek()){
          brides_queue.poll();
          grooms_queue.poll();
          flag = true;
        }else{
          // brides_queue.add(brides_queue.poll());
          grooms_queue.add(grooms_queue.poll());
        }
        // System.out.print(brides_queue);
        // System.out.println(grooms_queue);
      }
    }

    System.out.println(brides_queue.size());
  }
}
