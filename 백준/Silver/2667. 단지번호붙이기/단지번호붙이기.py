# 53분 시작

n = int(input())
apartments = []
flag = 0
count = []

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for _ in range(n):
    row = list(map(int, input()))
    apartments.append(row)

visited = [[0]*n for _ in range(n)]

def dfs(now):
    global flag
    global count
    visited[now[0]][now[1]] = flag
    count[flag-1] += 1

    for i in range(4):
        nx, ny = now[0] + dx[i], now[1] + dy[i]

        if(0 <= nx < n and 0 <= ny < n and apartments[nx][ny] == 1 and visited[nx][ny] == 0):
            dfs((nx, ny))

def solution():
    global flag

    for i in range(n):
        for j in range(n):
            if(visited[i][j] == 0 and apartments[i][j] == 1):
                flag += 1
                count.append(0)
                dfs((i,j))

solution()
print(flag)
count.sort()
print(*count, sep="\n")
