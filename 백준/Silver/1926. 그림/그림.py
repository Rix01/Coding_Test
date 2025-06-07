# 1로 연결된 것은 하나의 그림
# 가로, 세로 연결 => 상하좌우
# 세로 n, 가로 m
# 그림이 하나도 없는 경우 0
# 출력은 그림 개수 + 그림 넓이

from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

# paintings 입력받기
paintings = []
for i in range(n):
    paintings.append(list(map(int, input().split())))

# 상하좌우
move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 그림 사이즈 구하기(BFS)
def calcSize(paintings, pos):
    queue = deque()
    paintings[pos[0]][pos[1]] = 0
    queue.append(pos)
    size = 1
    while queue:
        x, y = queue.popleft()
        for dx, dy in move:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if paintings[nx][ny] == 1:
                    paintings[nx][ny] = 0
                    queue.append((nx, ny))
                    size += 1
    return size


# 1인 부분 찾고 calcSize 호출
def findResult(paintings):
    paintingSize = []
    cnt = 0
    for i in range(n):
        for j in range(m):
            if(paintings[i][j] == 1):
                cnt += 1
                paintingSize.append(calcSize(paintings, (i,j)))
    if(cnt == 0):
        return (0, 0)
    return (cnt, max(paintingSize))

res = findResult(paintings)
if(res[0] == 0):
    print(0)
    print(0)
else:
    print(res[0])
    print(res[1])
