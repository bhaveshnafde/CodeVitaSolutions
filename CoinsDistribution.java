import java.util.*;
import java.io.*;

public class CoinsDistribution{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int amount = Integer.parseInt(br.readLine());
    int five = (int)(amount-4)/5;
    amount -= 5 * five;
    int one;
    if(amount%2==0){
      one = 2;
    }else{
      one = 1;
    }
    amount -= one;
    int two = amount/2;

    System.out.println((five+two+one)+" "+five+" "+two+" "+one);
  }
}
