import java.io.*;
import java.util.*;

class Solution {
    int[][] picture;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    List<Integer> areas = new ArrayList<>();
    
    public int[] solution(int m, int n, int[][] picture) {
        this.picture = picture;
        int areaCount = 0;
        
        // 돌면서 0이 나닌 곳 시작, 해당 영역 숫자 확인
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] != 0 && picture[i][j] != -1) {
                    int nowAreaNumber = picture[i][j];
                    areaCount++;
                    bfs(new Position(i, j), nowAreaNumber);
                }
            }
        }
        
        areas.sort(Collections.reverseOrder());
        
        int[] answer = new int[2];
        answer[0] = areaCount;
        answer[1] = areas.get(0) - 1;
        
        return answer;
    }
    
    public void bfs(Position pos, int nowAreaNumber) {
        
        Deque<Position> queue = new ArrayDeque<>();
        queue.addLast(pos);
        
        int count = 0; // 해당 pos, nowAreaNumber로 시작해서 카운트 시작하고 다 끝나면 areas에 기록
        
        while(!queue.isEmpty()) {
            Position now = queue.pollFirst();
            int nowR = now.r;
            int nowC = now.c;
            count++;
            
            for(int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                
                if(nextR >=0 && nextR < picture.length && nextC >=0 && nextC < picture[0].length) {
                    // nowAreaNumber랑 일치하면 -1로 바꾸고 큐에 넣기
                    if(picture[nextR][nextC] == nowAreaNumber) {
                        picture[nextR][nextC] = -1;
                        queue.addLast(new Position(nextR, nextC));
                    }
                }
            }
        }
        
        areas.add(count);
    }
    
    public class Position{
        int r;
        int c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}