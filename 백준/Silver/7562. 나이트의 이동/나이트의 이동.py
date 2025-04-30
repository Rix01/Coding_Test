# 일단 테스트 케이스 맨 첫 번째 꺼 생각하면서...
import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

# 나이트의 이동
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

def findDestination(start, end, l):
    # 큐에 이동 횟수까지 저장.
    queue = deque([(start[0],start[1], 0)])
    while queue:
        x, y, move = queue.popleft()
        visited[x][y] = 1

        if(x==end[0] and y==end[1]):
            return move

        for i in range(8):
            nx, ny = x + dx[i], y + dy[i]
            if(0<= nx < l and 0<= ny < l):
                if(visited[nx][ny] == 0):
                    visited[nx][ny] = 1
                    queue.append((nx, ny, move+1))

for _ in range(t):
    l = int(input())
    visited = [[0]*l for _ in range(l)]

    start = list(map(int, input().split()))
    end = list(map(int, input().split()))
    # 탐색(start, end, l)
    res = findDestination(start, end, l)
    print(res)