n= int(input())
rgbs = [[0, 0, 0] for i in range(n)]
cost = []

for i in range(n):
    cost.append(list(map(int, input().split())))

rgbs[0][0], rgbs[0][1], rgbs[0][2] = cost[0][0], cost[0][1], cost[0][2]

for i in range(1, n):
    rgbs[i][0] = min(rgbs[i-1][1]+cost[i][0], rgbs[i-1][2]+cost[i][0])
    rgbs[i][1] = min(rgbs[i-1][0]+cost[i][1], rgbs[i-1][2]+cost[i][1])
    rgbs[i][2]= min(rgbs[i-1][0]+cost[i][2], rgbs[i-1][1]+cost[i][2])

result = min(rgbs[n-1][0], rgbs[n-1][1], rgbs[n-1][2])

print(result)