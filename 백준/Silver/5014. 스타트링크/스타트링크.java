import java.io.*;
import java.util.*;

public class Main {
    public static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[] dist = new int[f + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(s);
        dist[s] = 0;

        while(!queue.isEmpty()) {
            int now = queue.pollFirst();

            int up = now + u;
            int down = now - d;

            if(up >= 1 && up <= f && dist[up] == -1) {
                queue.addLast(up);
                dist[up] = dist[now] + 1;
            }

            if(down >= 1 && down <= f && dist[down] == -1) {
                queue.addLast(down);
                dist[down] = dist[now] + 1;
            }
        }

        if(dist[g] != -1) {
            bw.write(String.valueOf(dist[g]));

        }
        else {
            bw.write("use the stairs");
        }
        bw.flush();
        bw.close();
    }
}
