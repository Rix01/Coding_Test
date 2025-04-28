import sys
from collections import deque
input = sys.stdin.readline

n, m, v = map(int, input().split())

graph = [[0]*(n+1) for _ in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

answerDfs = []

def dfs(graph, start, visited):
    stack = []
    stack.append(start)
    visited[start] = 1
    answerDfs.append(start)

    while stack:
        now = stack[-1]

        # 다음 이동할 노드 찾았는지
        findNext = False

        for i in range(1, n+1):
            if graph[now][i] == 1 and visited[i] == 0:
                findNext = True
                stack.append(i)
                visited[i] = 1
                answerDfs.append(i)
                break

        if not findNext:
            stack.pop()

def dfs2(now):
    visited[now] = 1
    answerDfs.append(now)

    for i in range(1, n+1):
        if graph[now][i] == 1 and visited[i] == 0:
            dfs2(i)

answerBfs = []
def bfs(graph, start, visited):
    que = deque([start])
    visited[start] = 1

    while que:
        now = que.popleft()
        answerBfs.append(now)

        for i in range(1, n+1):
            if graph[now][i] == 1 and visited[i] == 0:
                que.append(i)
                visited[i] = 1


dfs2(v)
visited = [0] * (n+1)
bfs(graph, v, visited)

print(*answerDfs)
print(*answerBfs)

