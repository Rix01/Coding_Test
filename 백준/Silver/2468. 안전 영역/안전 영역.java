import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] original;
  static int[][] perHeight;
  static int maxHeight = Integer.MIN_VALUE;
  static int maxCount = Integer.MIN_VALUE;

  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  public static void afterRain(int height) {
    // 깊은 복사
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        perHeight[i][j] = original[i][j];
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        perHeight[i][j] = Math.max(0, perHeight[i][j]-height);  // 음수값 안 들어가도록
      }
    }
  }

  public static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {x, y});
    perHeight[x][y] = 0;  // 방문 표시

    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      for(int i = 0; i<4; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];
        if(nx>=0 && nx <n && ny>=0 && ny<n) {
          if(perHeight[nx][ny] != 0) {  // 잠기지 않았다면
            perHeight[nx][ny] = 0; // 방문 표시
            queue.offer(new int[] {nx, ny}); // 큐에 넣기
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(reader.readLine());
    original = new int[n][n];
    perHeight = new int[n][n];
    for(int i = 0; i < n; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      for(int j = 0; j < n; j++) {
        original[i][j] = Integer.parseInt(tokenizer.nextToken());
        maxHeight = Math.max(maxHeight, original[i][j]);
      }
    }

    for(int h = 0; h <= maxHeight; h++) {
      int count = 0;
      afterRain(h);
      // perHeight를 토대로 bfs 수행
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          if(perHeight[i][j] != 0) {  // 잠기지 않았다면
            count++;
            bfs(i, j);
          }
        }
      }
      maxCount = Math.max(maxCount, count);
    }
    writer.write(maxCount + "\n");
    writer.close();
  }
}
