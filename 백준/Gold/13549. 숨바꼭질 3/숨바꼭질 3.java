import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static final int MAX_POSITION = 100_000;
    static int[] minTime = new int[MAX_POSITION + 1];
    static int[] visited = new int[MAX_POSITION + 1];

    static class Node implements Comparable<Node> {
        int position;
        int time;

        Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        // 이 문제에서는 시간이 가중치라고 생각하면 된다.
        // 순간이동의 경우 0
        // 걷기의 경우 1
        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 다익스트라로 최단 시간 찾기
        int answer = findMinTime();
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int findMinTime() {
        // 각 위치까지의 최소 시간 배열
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[n] = 0; // 시작 위치는 0

        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(n, 0));

        // 메인 로직
        while(!pq.isEmpty()) {
            Node current = pq.poll();   // 최단 거리 노드 꺼내기

            // 동생 찾았으면 시간 반환
            if(current.position == k) {
                return current.time;
            }

            if(visited[current.position] == 1) {
                continue;
            }

            // 방문 표시
            visited[current.position] = 1;

            // 3가지 이동 방법 시도
            tryMove(current, pq);
        }
        return 0;
    }

    static void tryMove(Node current, PriorityQueue<Node> pq) {
        int pos = current.position;

        // x-1 이동
        if(pos - 1 >=0 && pos -1 <= MAX_POSITION && minTime[pos-1] > current.time + 1) {
            minTime[pos - 1] = current.time + 1;
            pq.offer(new Node(pos - 1, current.time + 1));
        }

        // x+1 이동
        if(pos + 1 >= 0 && pos + 1 <= MAX_POSITION && minTime[pos + 1] > current.time + 1) {
            minTime[pos + 1] = current.time + 1;
            pq.offer(new Node(current.position + 1, current.time +  1));
        }

        // 2*x 이동
        if(pos * 2 >= 0 && pos * 2 <= MAX_POSITION && minTime[pos * 2] > current.time) {
            minTime[pos * 2] = current.time;
            pq.offer(new Node(2 * current.position, current.time));
        }
    }
}