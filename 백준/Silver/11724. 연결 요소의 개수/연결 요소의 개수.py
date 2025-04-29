import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 정점 n, 간선 m
n, m = map(int, input().split())

connection = dict()
# 일단 n개만큼 만들어두기
for i in range(n):
    connection[i+1] = []

visited = [0]*(n+1)

for i in range(m):
    a, b = map(int, input().split())
    connection[a].append(b)
    connection[b].append(a)

# print(connection)

def dfs(node):
    if visited[node]==0:
        visited[node] = 1
        for neighbor in connection[node]:
            dfs(neighbor)

cnt = 0
for i in range(1, n+1):
    if visited[i]==0:
        dfs(i)
        cnt += 1

print(cnt)

