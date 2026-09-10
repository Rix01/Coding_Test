import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n+1][n+1];
        
        // 처음에는 INF로 초기화
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        // 양방향 다리 비용 넣기
        for(int[] fare:fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            dist[from][to] = Math.min(dist[from][to], cost);
            dist[to][from] = Math.min(dist[to][from], cost);
        }
        
        for(int mid = 1; mid <= n; mid++) {
            for(int from=1; from<=n; from++) {
                if(dist[from][mid] == INF) continue;
                for(int to=1; to <= n; to++) {
                    if(dist[mid][to] == INF) continue;
                    dist[from][to] = Math.min(dist[from][to], dist[from][mid] + dist[mid][to]);
                }
            }
        }
        
        int answer = INF;
        
        for(int mid = 1; mid <=n; mid++ ) {
            if(dist[s][mid] == INF ||
              dist[mid][a] == INF ||
              dist[mid][b] == INF) {
                continue;
            }
            int cost = dist[s][mid] + dist[mid][a] + dist[mid][b];
            answer = Math.min(answer, cost);
        }
        return answer;
    }
}