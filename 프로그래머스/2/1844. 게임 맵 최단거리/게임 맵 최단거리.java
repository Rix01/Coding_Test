import java.io.*;
import java.util.*;

class Solution {
    // 상하좌우
    int[] dc = {1, -1, 0, 0};
    int[] dr = {0, 0, 1, -1};
    
    
    public int solution(int[][] maps) {
        int n = maps[0].length; // 가로(열)
        int m = maps.length; // 세로(행)
        
        Position startPos = new Position(0, 0, 1); // 시작 좌표
        
        Deque<Position> queue = new ArrayDeque<>();
        queue.addLast(startPos);
        
        while(!queue.isEmpty()) {
            Position nowPos = queue.pollFirst();
            int nowR = nowPos.r;
            int nowC = nowPos.c;
            int nowValue = nowPos.value;
            
            // 상하좌우 탐색
            for(int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                
                // 범위 안 넘거나 maps 값이 0이 아니면
                if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && maps[nextR][nextC] == 1) {
                    maps[nextR][nextC] =  nowValue + 1;
                    queue.addLast(new Position(nextR, nextC, nowValue + 1));
                }
            }
        }
        
        if(maps[m-1][n-1] == 1) {
            return -1;
        }
        
        return maps[m-1][n-1];
    }
    
    class Position {
        int r;
        int c;
        int value;
        
        Position(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
    
}

/*
    1이 갈 수 있는 곳
    0이 벽
    
    
    [1, 0, 1, 1, 1]
    [1, 0, 1, 0, 1]
    [1, 0, 1, 1, 1]
    [1, 1, 1, 0, 1]
    [0, 0, 0, 0, 1]
    
    첫 좌표 시작
    상하좌우 탐색
    있으면 큐에 다 넣기
        해당 좌표 maps에 값 비교해서 이전 값이랑 이전 좌표 +1 이랑 비교해서 기록
    m-1, n-1 값 출력
    
*/