import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Deque<Position> queue = new ArrayDeque<>();
        
        Position startPosition = new Position(0, 0, 1);
        visited[0][0] = true;
        queue.addLast(startPosition);
        
        while(!queue.isEmpty()) {
            Position currentPosition = queue.pollFirst();
            int x = currentPosition.getX();
            int y = currentPosition.getY();
            int value = currentPosition.getValue();
            
            if(x == n-1 && y == m -1) {
                return value;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if(maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        Position canGo = new Position(nextX, nextY, value + 1);
                        queue.addLast(canGo);
                    }
                }
            }
        }
        return -1;
    }
    
    public static class Position {
        public int x;
        public int y;
        public int value;
        
        public Position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getValue() {
            return value;
        }
    }
}