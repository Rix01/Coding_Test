import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int m;
    public static int n;
    public static int[][] farm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로(열)
            n = Integer.parseInt(st.nextToken()); // 세로(행)
            int k = Integer.parseInt(st.nextToken());
            int result = 0;
            farm = new int[n][m];

            // 배추밭 표시
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < m; c++) {
                    if(farm[r][c] == 1) {
                        Position position = new Position(r, c);
                        bfs(position);
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }

    private static void bfs(Position position) {
        Deque<Position> queue = new ArrayDeque<>();
        queue.addLast(position);
        farm[position.r][position.c] = 0;

        while(!queue.isEmpty()) {
            Position currentPosition = queue.pollFirst();

            for(int i = 0; i < 4; i++) {
                int currentC = currentPosition.c + dx[i];
                int currentR = currentPosition.r + dy[i];

                if(currentC >= 0 && currentC < m && currentR >=0 && currentR < n && farm[currentR][currentC] == 1 ) {
                    queue.addLast(new Position(currentR, currentC));
                    farm[currentR][currentC] = 0;
                }
            }
        }
    }

    private static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
