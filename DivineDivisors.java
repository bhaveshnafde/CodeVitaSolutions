import java.util.*;
import java.io.*;

class Main
{
  public static void main(String args[]) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());
	int sqrt = (int)Math.sqrt(number);
    ArrayList<Integer> arrli = new ArrayList<Integer>();
    for(int i = 1; i <= sqrt; i++){
    	if(number%i == 0){
          	System.out.print(i+" ");
        
			if(number/i!=i){
				arrli.add(number/i);
			}
		}
  	}
	Collections.sort(arrli);
	for(int arr : arrli){
		System.out.print(arr+" ");
	}
  }
}