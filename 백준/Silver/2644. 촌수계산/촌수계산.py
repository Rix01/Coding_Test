from collections import deque
n = int(input())

p1, p2 = map(int, input().split())
m = int(input())
family = dict()
visited = [0] * (n+1)

for _ in range(m):
    n1, n2 = map(int, input().split())
    if n1 not in family:
        family[n1] = [n2]
    else:
        family[n1].append(n2)
    if n2 not in family:
        family[n2] = [n1]
    else:
        family[n2].append(n1)
# {1: [2, 3], 2: [1, 7, 8, 9], 3: [1], 7: [2], 8: [2], 9: [2], 4: [5, 6], 5: [4], 6: [4]}

# 시작 지점 기준으로 촌수
queue = deque([(p1, 0)])
flag = 0
while queue:
    now, connect = queue.popleft()
    visited[now] = 1
    if now == p2:
        flag = 1
        print(connect)
        break
    connect += 1

    for fam in family[now]:
        # 방문하지 않은 곳이라면
        if visited[fam] == 0:
            queue.append((fam, connect))
if flag == 0:
    print(-1)