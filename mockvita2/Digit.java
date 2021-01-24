import java.io.*;
import java.util.*;

public class Digit {
  public static int bitScore(int n) {
    int large = 0, small = 9;

    while(n != 0)
    {
        int r = n % 10;
        large = Math.max(r, large);
        small = Math.min(r, small);
        n = n / 10;
    }
    int bit_score = (large*11) + (small*7);
    if(bit_score > 99) {
      bit_score = bit_score % 100;
    }
    return bit_score;
  }

  public static int getFirst(int n) {
    int first = n - (n%10);
    return first/10;
  }

  public static int getPair(int n){
    if(n==2) {
      return 1;
    } else if (n>=3) {
      return 2;
    }
    return 0;
  }

  public static int countPairs(int even[], int odd[], int n) {
    int sum = 0;
    int count_even[] = new int[10];
    int count_odd[] = new int[10];
    int count_pairs[] = new int[10];
    for(int i = 0; i < n; i++) {
      count_even[even[i]]++;
      count_odd[odd[i]]++;
    }
    for(int i = 0; i < 10; i++) {
       // System.out.print(count_even[i]+" ");
      if(count_even[i] <= 1 && count_odd[i] <= 1) {
        continue;
      }
      count_pairs[i] += getPair(count_even[i]) + getPair(count_odd[i]);
      count_pairs[i] = Math.min(2, count_pairs[i]);
    }

    for (int i = 0; i < count_pairs.length; i++) {
       sum = sum + count_pairs[i];
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int bit_score[] = new int[n];
    for(int i = 0; i < n; i++) {
      bit_score[i] = bitScore(arr[i]);
    }

    int even[] = new int[n/2];
    int odd[] = new int[n/2];

    int j = 0;
    for(int i = 0; i < n; i+=2) {
      even[j++] = getFirst(bit_score[i]);
    }
    j=0;
    for(int i = 1; i < n; i+=2) {
      odd[j++] = getFirst(bit_score[i]);
    }
    System.out.print(countPairs(even,odd,n/2));
  }
}
