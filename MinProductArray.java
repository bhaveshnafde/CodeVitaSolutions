  import java.util.*;
  import java.io.*;

  public class MinProductArray{

    public static int minProduct(int a[], int b[], int n, int k){
      int diff =  2147483647, temp = 0, pro = 0,pos = 0;
      for(int i = 0; i < n; i++){
        if(a[i]*b[i] > 0 && a[i] > 0){
          temp = (a[i] - 2*k) * b[i];
        }else if(a[i]*b[i] < 0 && a[i] < 0){
          temp = (a[i] - 2*k) * b[i];
        }else if(a[i]*b[i] > 0 && a[i] < 0){
          temp = (a[i] + 2*k) * b[i];
        }else if(a[i]*b[i] < 0 && a[i] > 0){
          temp = (a[i] + 2*k) * b[i];
        }
        if(temp < diff){
          pos = i;
        }
        diff = Math.min(diff, temp);
        pro += a[i]*b[i];
        //System.out.println(pos);
      }

      return (pro-(a[pos]*b[pos])) + diff;
    }

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int a[] = new int[n];
      int b[] = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++){
        b[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(minProduct(a,b,n,k));
    }
  }
