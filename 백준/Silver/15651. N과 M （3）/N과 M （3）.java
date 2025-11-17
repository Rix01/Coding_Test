import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[] result;
  static StringBuilder builder = new StringBuilder();

  static void backtrack(int depth) {
    if (depth == m) {
      for(int r: result) {
        builder.append(r).append(" ");
      }
      builder.append("\n");
      return;
    }

    for(int i = 1; i <= n; i++) {
      result[depth] = i;
      backtrack(depth + 1);
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    n = Integer.parseInt(tokenizer.nextToken());
    m = Integer.parseInt(tokenizer.nextToken());

    result = new int[m];
    backtrack(0);

    // 출력
    writer.write(builder.toString());
    writer.close();
  }
}