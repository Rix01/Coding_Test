import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    bw.write(bfs(n,k) + "\n");
    bw.close();
  }

  public static int bfs(int start, int end)
  {
    boolean[] visited = new boolean[100_001];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    visited[start] = true;

    while(!queue.isEmpty())
    {
      int[] cur = queue.poll();
      int pos =  cur[0];
      int time = cur[1];

      if(pos==end) {
        return time;
      }

      int[] nextMoves = {pos-1, pos+1, pos*2};

      for(int nextMove : nextMoves) {
        if(nextMove >= 0 && nextMove <=100_000 && visited[nextMove] == false){
          queue.add(new int[]{nextMove, time+1});
          visited[nextMove] = true;
        }
      }
    }
    return -1;
  }
}