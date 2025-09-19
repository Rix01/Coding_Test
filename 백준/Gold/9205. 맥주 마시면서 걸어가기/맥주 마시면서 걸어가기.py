from collections import deque

def distance(p1, p2):
    return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

def solution():
    n = int(input())
    positions = []
    for _ in range(n+2):
        x, y = map(int, input().split())
        positions.append((x, y))
    # 방문여부
    visited = [0] * (n+2)

    start = positions[0]
    end = positions[-1]
    queue = deque([start])
    visited[0] = 1

    max_distance = 1000 # 어차피 중간중간 갈 수 있는 곳 있으면 리필 되니까 최대 1000m 이내에 있는지 여부만 확인하면 됨

    while queue:
        now = queue.popleft()

        if now == end:
            return "happy"

        for i in range(len(positions)):
            if(not visited[i] and distance(positions[i], now) <= max_distance):
                visited[i] = 1
                queue.append(positions[i])
    return "sad"

t = int(input())
for _ in range(t):
    print(solution())