import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] maps;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        // 입력값으로 maps 채우기
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0; // 단지 개수
        List<Integer> apartments = new ArrayList<>(); // 단지 내 아파트 개수 추가할 리스트

        // 돌면서 1인 곳 만나면 bfs 시작
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(maps[i][j] == 1) {
                    int apartmentCount = bfs(new Position(i, j));
                    apartments.add(apartmentCount);
                    count++;
                }
            }
        }
        // 정렬
        Collections.sort(apartments);
        
        bw.write(count + "\n");
        for(Integer apt:apartments) {
            bw.write(String.valueOf(apt + "\n"));
        }
        bw.close();
    }

    public static int bfs(Position position) {
        Deque<Position> queue = new ArrayDeque<>();
        int apartmentCount = 1;
        queue.addLast(position);
        maps[position.r][position.c] = 0;

        while(!queue.isEmpty()) {
            Position curPos = queue.pollFirst();
            for(int i = 0; i < 4; i++) {
                int nextX = curPos.c + dx[i];
                int nextY = curPos.r + dy[i];

                if(nextX >= 0 && nextX < n && nextY >=0 && nextY < n && maps[nextY][nextX] == 1) {
                    queue.addLast(new Position(nextY, nextX));
                    maps[nextY][nextX] = 0;
                    apartmentCount++;
                }
            }
        }

        return apartmentCount;
    }

    public static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
