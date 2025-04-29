# 출력값은 단지 수, 각 단지별 집 수
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
town = []
visited = [[0]*n for _ in range(n)]
for i in range(n):
    town.append(list(map(int, input().strip())))

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

homeCnt = 0
def dfs(a, b):
    global homeCnt
    if town[a][b] == 1 and visited[a][b] == 0:
        visited[a][b] = 1
        homeCnt += 1

        for i in range(4):
            nx, ny = a+dx[i], b+dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                dfs(nx, ny)

townCnt = 0
homeCnts = []
for i in range(n):
    for j in range(n):
        if town[i][j] == 1 and visited[i][j] == 0:
            townCnt += 1
            homeCnt = 0
            dfs(i, j)
            homeCnts.append(homeCnt)

print(townCnt)
# 오름차순 정렬.
homeCnts.sort()
for h in homeCnts:
    print(h)