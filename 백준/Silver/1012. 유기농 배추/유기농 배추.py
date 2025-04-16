from collections import deque

def solution(m, n, k):
    farm = [[0 for i in range(m)] for j in range(n)]
    visited = [[0 for i in range(m)] for j in range(n)]
    cabbage_positions = []  # 배추 위치 기억 위한 배열

    # k번 입력
    for _ in range(k):
        x, y = map(int, input().split()) # 열, 행 순서로 받음
        farm[y][x]=1
        cabbage_positions.append((x,y))

    # 이동 상우하좌
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]


    cnt = 0 # 결과값
    for a, b in cabbage_positions:
        if visited[b][a] == 0:  # 아직 방문하지 않은 배추라면
            findQueue = deque() # 배추 인접 큐
            visited[b][a] = 1
            findQueue.append([a,b])

            while(findQueue):
                x, y = findQueue.popleft()
                
                # 상우하좌 탐색 후 큐에 추가
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]

                    # x범위는 0 <= x < m
                    # y 범위는 0<= y < n
                    if(0<=nx<m and 0<=ny<n):
                        if(farm[ny][nx]==1 and visited[ny][nx]==0):
                            visited[ny][nx] = 1
                            findQueue.append([nx, ny])
            cnt+=1
    return cnt

# 입력 1
t = int(input())

for i in range(t):
    # 입력 2
    m, n, k = map(int, input().split()) # 가로:m => 열, 세로:n => 행
    print(solution(m,n,k))
    