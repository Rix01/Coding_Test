import java.io.*;
import java.util.*;
public class Main {
  static int n;
  static long[][] ingredients;
  static long minDiff;

  static void backtrack(int depth, long nowSour, long nowBitter, int count) {
    if(depth == n) {
      // 재료가 하나 이상일 때
      if (count > 0) {
        long diff = Math.abs(nowSour - nowBitter);
        minDiff = Math.min(minDiff, diff);
      }
      return;
    }

    // 해당 재료 선택 O
    backtrack(depth + 1, nowSour * ingredients[depth][0],
        nowBitter + ingredients[depth][1], count + 1);

    // 해당 재료 선택 X
    backtrack(depth + 1, nowSour, nowBitter, count);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    // 재료 개수 입력
    n = Integer.parseInt(reader.readLine());

    ingredients = new long[n][2];

    // 재료 입력
    for(int i = 0; i < n; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      ingredients[i][0] = Long.parseLong(tokenizer.nextToken());  // 신맛
      ingredients[i][1] = Long.parseLong(tokenizer.nextToken());  // 쓴맛
    }

    minDiff = Long.MAX_VALUE;

    backtrack(0, 1, 0, 0);

    writer.write(String.valueOf(minDiff));
    writer.close();
  }
}