# 41분에 시작

n = int(input())
line = int(input())

computer = [[0]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)
count = 0

for _ in range(line):
    n1, n2 = map(int, input().split())
    computer[n1][n2] = 1
    computer[n2][n1] = 1

def dfs(node):
    global count
    visited[node] = 1
    count += 1
    for i in range(1, n+1):
        if(visited[i] == 0 and computer[node][i] == 1):
            dfs(i)

dfs(1)
print(count-1)