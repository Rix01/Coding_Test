import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
miro = []

for _ in range(n):
    miro.append(list(map(int, input().strip())))

# 상하좌우
dx = [-1,1,0,0]
dy=[0,0,-1,1]

# 방문 표시
visited = [[0]*m for _ in range(n)]

def bfs(a, b):
    queue = deque([(a, b)])

    while queue:
        x, y = queue.popleft()
        visited[x][y] = 1

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if miro[nx][ny] == 1 and visited[nx][ny] == 0:
                    miro[nx][ny] = miro[x][y] + 1
                    queue.append((nx, ny))
                    visited[nx][ny] = 1

bfs(0,0)
print(miro[n-1][m-1])
