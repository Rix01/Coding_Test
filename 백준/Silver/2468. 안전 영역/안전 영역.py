# 일단 물에 잠기는 지역을 0으로 표시.
# 그 이후에 dfs든 bfs든 탐색하면서 몇개의 영역이 살아남는지 확인.

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())

area = []
for i in range(n):
    area.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def markSinkArea(rain):
    for i in range(n):
        for j in range(n):
            if area[i][j] >= rain:
                sinkArea[i][j] = 1

def dfs(x,y):
    if sinkArea[x][y] == 1 and visited[x][y] == 0:
        visited[x][y] = 1

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                dfs(nx, ny)

cnt = 0
def checkMax(sinkArea):
    global cnt
    for i in range(n):
        for j in range(n):
            if sinkArea[i][j] == 1 and visited[i][j] == 0:
                cnt += 1
                dfs(i,j)

cnts = []
for i in range(1, 101):
    sinkArea = [[0] * n for _ in range(n)]  # 물에 잠기지 않는 부분 1로 표시
    visited = [[0] * n for _ in range(n)]
    markSinkArea(i)
    cnt = 0
    checkMax(sinkArea)
    cnts.append(cnt)

print(max(cnts))
