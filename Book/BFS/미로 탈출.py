from collections import deque

# N, M 입력
n, m = map(int, input().split())

# 미로 입력
maze = []
for i in range(n):
    maze.append(list(map(int, input())))

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    while(queue):
        x, y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            # 범위 벗어나면 무시
            if nx<=-1 or nx>=n or ny<=-1 or ny>=m:
                continue
            # 0이면 무시
            if maze[nx][ny]==0:
                continue
            if maze[nx][ny]==1:
                maze[nx][ny] = maze[x][y] + 1
                queue.append((nx, ny))
    return maze[n-1][m-1]

print(f"최소로 움직이는 칸의 수 : {bfs(0,0)}")