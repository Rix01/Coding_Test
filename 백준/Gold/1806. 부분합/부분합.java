import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    int[] numbers = new int[n];
    st =  new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++){
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    int start=0, end=0, minLength=Integer.MAX_VALUE, hap=0;
    boolean flag = false;
    while(end < n) {
      hap += numbers[end];
      while(hap >= s) {
        flag = true; // 하나라도 찾았다는 표시
        minLength = Math.min(minLength, (end-start+1));
        hap -= numbers[start];
        start++;
      }
      end++;
    }
    if(flag==false) minLength = 0;
    bw.write(minLength + "\n");
    bw.close();
  }
}