from collections import deque

# 맨해튼 거리 구하는 함수
def distance(p1, p2):
    return abs(p2[0] - p1[0]) + abs(p2[1] - p1[1])

def solution():
    n = int(input())
    positions = []
    for _ in range(n + 2):
        x, y = map(int, input().split())
        positions.append((x, y))

    start = positions[0]
    end = positions[-1]

    # 최대 이동 가능 거리
    max_dist = 1000

    queue = deque([start])
    visited = [0] * (n+2)
    visited[0] = 1

    while queue:
        now = queue.popleft()

        # 도착지 도달 여부 확인
        if now == end:
            return "happy"

        # 다음 위치 이동 가능 여부 확인
        for i in range(n+2):
            next = positions[i]
            if not visited[i] and distance(now, next) <= max_dist:
                visited[i] = 1
                queue.append(next)
    # 다 돌고도 도착 못함
    return "sad"

t = int(input())
for _ in range(t):
    print(solution())