import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] board) {
        int rLen = board.length;
        int cLen = board[0].length();
        
        char[][] boardList = new char[rLen][cLen];
        boolean[][] visited = new boolean[rLen][cLen];
        
        // char 배열로 다시 재조립
        for(int r = 0; r < rLen; r++) {
            boardList[r] = board[r].toCharArray();
        }
        
        // 상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // R 좌표 찾기
        Position rPos = findRPosition(boardList);
        
        Deque<Item> queue = new ArrayDeque<>();
        queue.addLast(new Item(rPos, 0)); // 첫 좌표 R 넣기
        
        while(!queue.isEmpty()) {
            Item nowItem = queue.pollFirst();
            int nowR = nowItem.pos.r;
            int nowC = nowItem.pos.c;
            int prevCount = nowItem.count;
            
            for(int i = 0; i < 4; i ++) {
                // D이거나 범위 벗어난 것이 아니라면 해당 방향으로 쭉 미끄러짐
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                
                while(nextR >= 0 && nextR < rLen && 
                      nextC >=0 && nextC < cLen && 
                      boardList[nextR][nextC] != 'D') {
                    nextR += dr[i];
                    nextC += dc[i];
                }
                if(boardList[nowR][nowC] == 'G') {
                    return prevCount;
                }
                // while문 벗어났다는 것은 범위 넘어서거나 장애물 만났다는 뜻이므로 되돌림
                nextR -= dr[i];
                nextC -= dc[i];
                
                // 
                if(!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.addLast(new Item(new Position(nextR, nextC), prevCount + 1));
                }
            }
        }
        return -1;
    }
    
    Position findRPosition(char[][] boardList) {
        int rLen = boardList.length;
        int cLen = boardList[0].length;
        Position rPos = null;
        for(int r = 0; r < rLen; r++) {
            for(int c = 0; c < cLen; c++) {
                if(boardList[r][c] == 'R') {
                    rPos = new Position(r, c);
                }
            }
        }
        return rPos;
    }
    
    class Position {
        int r;
        int c;
        
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    class Item {
        Position pos;
        int count;
        
        Item(Position pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }
}

/*
최소 몇번의 이동이 필요한지 말하는 게임
상하좌우로 이동
가장자리 부딪힐 때까지 미끄러져 움직임
.은 빈 공간
R은 로봇의 처음 위치
D는 장애물 위치
G는 목표지점
목표 도달 불가능하면 -1 리턴
*/