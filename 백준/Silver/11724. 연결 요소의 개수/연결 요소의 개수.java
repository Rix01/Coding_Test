import java.io.*;
import java.util.*;

public class Main {
  static HashMap<Integer, List<Integer>> adjanceyList = new HashMap<>();
  static int[] visited;
  static int n, m;

  public static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(node);  // 시작 노드 넣기
    visited[node] = 1;  // 방문 표시

    while(!queue.isEmpty()) {
      int now =  queue.poll();
      // 해당 인접 리스트
      List<Integer> neighbors = adjanceyList.get(now);
      for(Integer neighbor : neighbors) {
        if(visited[neighbor] == 0) {
          visited[neighbor] = 1;  // 방문 표시 후
          queue.offer(neighbor);  // 큐에 넣기
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    n = Integer.parseInt(tokenizer.nextToken());
    m = Integer.parseInt(tokenizer.nextToken());

    visited = new int[n+1];

    // n개만큼 List 만들기
    for(int i = 1; i<=n; i++) {
      adjanceyList.put(i, new ArrayList<>());
    }

    for(int i = 0; i < m; i++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int u =  Integer.parseInt(tokenizer.nextToken());
      int v =  Integer.parseInt(tokenizer.nextToken());
      adjanceyList.get(u).add(v);
      adjanceyList.get(v).add(u);
    }
    int count = 0;
    for(int i = 1; i <= n; i++) {
      if(visited[i]==0) { // 방문 안 했으면
        count++;
        bfs(i);
      }
    }
    writer.write(count+"\n");
    writer.close();
  }
}
