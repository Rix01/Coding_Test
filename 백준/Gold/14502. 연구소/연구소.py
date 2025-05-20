import copy
import sys
from collections import deque
from itertools import combinations  # 조합
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    graph.append(list(map(int, input().split())))

# 빈 칸, 바이러스 위치 미리 저장
blanks = []
viruses = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            blanks.append((i, j))
        elif graph[i][j] == 2:
            viruses.append((i, j))

# 바이러스 퍼짐
def spreadVirus(walls):
    queue = deque(viruses)
    tempGraph = copy.deepcopy(graph)

    # 조합에 따라 벽 세우기
    for x, y in walls:
        tempGraph[x][y] = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if tempGraph[nx][ny] == 0:
                    tempGraph[nx][ny] = 2
                    queue.append((nx, ny))
    safe = sum(row.count(0) for row in tempGraph)
    return safe

answer = 0
# 벽 3개 세우기 (조합으로)
for walls in combinations(blanks, 3):
    answer = max(answer, spreadVirus(walls))

print(answer)
