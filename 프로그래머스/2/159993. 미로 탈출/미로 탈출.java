import java.io.*;
import java.util.*;

class Solution {
    char[][] miro;
    int[][] miroNumber;
    boolean[][] visited;
    int rowLen;
    int colLen;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int sR = 0;
    int sC = 0;
    int count = 0;
    boolean flag = false;
    
    public int solution(String[] maps) {
        this.rowLen = maps.length;
        this.colLen = maps[0].length();
        this.visited = new boolean[rowLen][colLen];
        this.miro = new char[rowLen][colLen];
        this.miroNumber = new int[rowLen][colLen];
        
        // String[] maps를 char[][]로 변경
        for(int i = 0; i < rowLen; i++) {
            miro[i] = maps[i].toCharArray();
        }
        
        // 시작 지점이 어디인지 탐색
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(miro[r][c] == 'S') {
                    this.sR = r;
                    this.sC = c;
                    break;
                }
            }
        }
        Position sPos = new Position(sR, sC);
        bfs(sPos, 'L'); // 레버까지
        if(flag == false) {
            return -1;
        }
        flag = false;
        
        sPos = new Position(sR, sC);
        bfs(sPos, 'E'); // 출구까지
        if(flag == false) {
            return -1;
        }
        
        return count;
    }
    
    class Position {
        int r;
        int c;
        
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public void bfs(Position sPos, char goal) {
        Deque<Position> queue = new ArrayDeque<>();
        
        queue.addLast(sPos); // 스타트 좌표 넣기
        visited[sR][sC] = true; // 방문 표시
        
        while(!queue.isEmpty()) {
            Position nowPos = queue.pollFirst();
            int nowR = nowPos.r;
            int nowC = nowPos.c;
            
            if(miro[nowR][nowC] == goal) {
                count += miroNumber[nowR][nowC];
                visited = new boolean[rowLen][colLen]; // 초기화
                miroNumber = new int[rowLen][colLen]; // 초기화
                sR = nowR;
                sC = nowC;
                flag = true;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                
                // 범위 안에 있고, 방문한 곳이 아니고, X가 아니면
                if(nextR >=0 && nextR < rowLen && nextC >=0 && nextC < colLen && !visited[nextR][nextC] && miro[nextR][nextC] != 'X') {
                    queue.addLast(new Position(nextR, nextC));
                    visited[nextR][nextC] = true;
                    miroNumber[nextR][nextC] = miroNumber[nowR][nowC] + 1;
                }
            }
        }
    }
}

/*

각 칸은 통로 또는 벽
통로들 중 한 칸에는 미로 빠져나가는 문 존재
당겨서만 열 수 있음
레버도 통로들 중 한 칸에 있음

즉, 출발지 -> 레버 -> 빠져나가는 문

한 칸 이동에 1초
최대한 빠르게 미로를 빠져나가는 데 걸리는 시간 구하기

탈출할 수 없다면 -1 리턴

S : 시작 지점
E : 출구
L : 레버
O : 통로
X : 벽


예시 변형해서 생각하기 
16까지 갔다가 다시 리셋. (방문 배열 초기화)
즉, 16+12

"SOOOE",
"XXXXO",
"OOOOO",
"OXXXX",
"OOOOL"

*/
