import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int g = Integer.parseInt(br.readLine());
    List<Integer> result = new ArrayList<>();

    for(int y = 1; y<=100_000; y++) {
      long xx = (long) y * y + g;
      long x = (long) Math.sqrt(xx);

      if(x * x == xx) {
        result.add((int) x);
      }
    }

    if(result.size() == 0) {
      System.out.println(-1);
    } else {
      for(int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
      }
    }
  }
}