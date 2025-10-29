import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[] parent;
  static List<Edge> edges;

  static class Edge implements Comparable<Edge> {

    int start, end, weight;

    Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y) {
    parent[y] = x;
  }

  static int kruskal() {
    // 간선 정렬
    Collections.sort(edges);

    int totalCost = 0;
    int connectCount = 0;

    for (Edge edge : edges) {
      int rootStart =  find(edge.start);
      int rootEnd = find(edge.end);
      if (rootStart != rootEnd) {
        union(rootStart, rootEnd);
        totalCost += edge.weight;
        connectCount++;

        if (connectCount == n - 1) {
          break;
        }
      }
    }
    return totalCost;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    // 부모 초기화
    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    // edge 초기화
    edges = new ArrayList<>();

    // 간선 입력받기
    for (int i = 1; i <= m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      edges.add(new Edge(start, end, weight));
    }

    System.out.println(kruskal());
  }
}
