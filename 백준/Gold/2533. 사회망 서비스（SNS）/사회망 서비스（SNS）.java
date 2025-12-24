import java.io.*;
import java.util.*;

public class Main {
  private static ArrayList<Integer>[] adj;
  private static int[] visited;
  private static int[][] dp;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    adj = new ArrayList[n+1];
    visited = new int[n+1];
    dp = new int[n+1][2];

    for(int i = 0; i<n+1; i++) {
      adj[i] = new ArrayList<>();
    }

    for(int i = 0; i < n - 1; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      adj[u].add(v);
      adj[v].add(u);
    }

    dfs(1);

    bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
    bw.close();
  }

  public static void dfs(int curNode)
  {
    visited[curNode] = 1;
    // dp 초기화
    dp[curNode][0] = 0;
    dp[curNode][1] = 1;

    for(int child : adj[curNode]) {
      if(visited[child] == 0) {
        dfs(child);

        dp[curNode][0] += dp[child][1];
        dp[curNode][1] += Math.min(dp[child][0], dp[child][1]);
      }
    }
  }
}