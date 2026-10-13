import java.io.*;
import java.util.*;

class Solution {
    char[][] charMap;
    List<Integer> stay = new ArrayList<>();
    int[] dR = {-1, 1, 0, 0};
    int[] dC = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        // maps를 char[][] 형태로 변환
        charMap = new char[maps.length][maps[0].length()];
        
        // charMap 채우기
        for(int row = 0; row < maps.length; row++) {
            String rowStr = maps[row];
            char[] charRowStr = rowStr.toCharArray();
            
            for(int col = 0; col < maps[0].length(); col++) {
                charMap[row] = charRowStr;
            }
        }
        
        // 숫자인 곳 찾기
        boolean hasNum = false;
        for(int row = 0; row < maps.length; row++) {
            for(int col = 0; col < maps[0].length(); col++) {
                if(charMap[row][col] != 'X') {
                    hasNum = true;
                    int food = bfs(new Position(row, col, charMap[row][col]));
                    stay.add(food);
                }
            }
        }
        
        if(!hasNum) {
          return new int[]{-1};  
        }
        
        // 정렬
        Collections.sort(stay);
        
        // 배열로 바꾸기
        int[] answer = new int[stay.size()];
        for(int i = 0; i < stay.size(); i++) {
            answer[i] = stay.get(i);
        }
        
        return answer;
    }
    
    public int bfs(Position position) {
        int answer = 0;
        
        Deque<Position> queue = new ArrayDeque<>();
        // 현재 값 넣기
        queue.addLast(position);
        charMap[position.row][position.col] = 'X'; // 방문 표시
        
        while(!queue.isEmpty()) {
            Position nowPos = queue.pollFirst();
            int nowRow = nowPos.row;
            int nowCol = nowPos.col;
            int nowFood = nowPos.food;
            answer += nowFood;
            
            for(int i = 0; i < 4; i++) {
                int nextRow = nowRow + dR[i];
                int nextCol = nowCol + dC[i];
                
                // X가 아니고 범위 안이면
                if(nextRow >=0 && nextRow < charMap.length && nextCol >= 0 && nextCol < charMap[0].length) {
                    if(charMap[nextRow][nextCol] != 'X') {
                        queue.addLast(new Position(nextRow, nextCol, charMap[nextRow][nextCol]));
                        charMap[nextRow][nextCol] = 'X'; // 방문 표시
                    }
                }
            }
        }
        
        return answer;
    }
    
    public class Position {
        int row;
        int col;
        int food;
        
        Position(int row, int col, char food) {
            this.row = row;
            this.col = col;
            this.food = food - '0';
        }
    }
}


/*
직사각 형태의 격자
X 또는 1 ~ 9 >> 즉 문자로 저장
바다는 x, 무인도는 숫자(식량)

1이라는 수치가 곧 묵을 수 있는 날짜

X591X
X1X5X
X231X
1XXX1

1. 지낼 섬 없으면 -1 >> 즉 다 X
2. 섬이 몇개인지, 각 섬에서의 날짜 구하기
    1. 현재 위치에서 for문 돌면서 x가 아닌 곳 구하기
    2. 숫자 만나면 탐색 시작
        숫자를 hap에 더함
        방문 표시는 maps에서 수정해도 될 듯
    3. 숫자인 경우 계속 탐색하고 기록
3. 오름차순 정렬
4. List.toArray()
*/