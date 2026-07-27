import java.io.*;
import java.util.*;

class Solution {
    Map<Integer, List<Road>> towns;
    
    public int solution(int N, int[][] road, int K) {
        towns = new HashMap<>();
        
        for(int[] r:road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            
            towns.computeIfAbsent(from, key -> new ArrayList<>())
                .add(new Road(to, weight));
            
            towns.computeIfAbsent(to, key -> new ArrayList<>())
                .add(new Road(from, weight));
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[1] = 0;
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        
        while(!queue.isEmpty()) {
            int now = queue.pollFirst();
            
            List<Road> roads = towns.getOrDefault(now, new ArrayList<>());
            
            for(Road roadInfo : roads) {
                int next = roadInfo.other;
                int newDistance = distance[now] + roadInfo.weight;
                
                if(newDistance <= K && newDistance < distance[next]) {
                    distance[next] = newDistance;
                    queue.addLast(next);
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public class Road {
        int other;
        int weight;
        
        public Road(int other, int weight) {
            this.other = other;
            this.weight = weight;
        }
    }
}


/*
- 양방향 도로
- 도로를 지날 때 걸리는 시간은 도로별로 다름
- K 시간 이하로 배달이 가능한 마을에서만 주문 받음
- 음식 주문을 받을 수 있는 마을 개수를 return
- a,b,c에서
    a, b: 도로가 연결하는 두 마을의 번호
    c: 도로를 건너는 데 걸리는 시간

ex)
Road
 - to
 - weight
 from, to 모두 표시

[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]
1: (2, 1), (4, 2)
2: (1, 1), (3, 3), (5, 2)
3: (2, 3), (5, 1)
4: (1, 2), (5, 2)
5: (2, 2), (3, 1), (4, 2)

다 돌면서 제일 작은 값을 찾아서 갱신해줘야 하나?
1에서 출발이니까 1은 0
1에서 2까지 : 1
1에서 3까지 :
    2 거쳐서 가는 거 1 + 3 = 4
    2, 5 거쳐서 가는 거 1 + 2 + 1 = 4
    4, 5 거쳐서 가는 거 2 + 2 + 1 = 5
    즉, 4가 최소값. 즉 탈락
    
1에서 4까지: 2
1에서 5까지 1 + 2 = 3

bfs로도 될 것 같기도 한데..?

*/