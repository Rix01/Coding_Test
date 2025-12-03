import java.io.*;
import java.util.*;

public class Main {

  static int t;
  static int m, n, k;
  static int[][] arr;

  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  public static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {y, x});
    arr[y][x] = 0;  // 방문 표시

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowX = now[1], nowY = now[0];
      for(int i = 0; i < 4; i++) {
        int nx = nowX + dx[i];
        int ny = nowY + dy[i];
        if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
          if(arr[ny][nx] == 1) {
            arr[ny][nx] = 0;
            queue.offer(new int[] {ny, nx});
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(reader.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      m = Integer.parseInt(tokenizer.nextToken());
      n = Integer.parseInt(tokenizer.nextToken());
      k = Integer.parseInt(tokenizer.nextToken());

      arr = new int[n][m];
      int count = 0;

      for (int j = 0; j < k; j++) {
        tokenizer = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        arr[y][x] = 1;  // 배추 표시
      }

      for(int row = 0; row < n; row++){
        for(int col = 0; col < m; col++){
          if(arr[row][col] == 1) {
            count++;
            bfs(row, col);
          }
        }
      }
      writer.write(count+"\n");
    }
    writer.close();
  }
}
