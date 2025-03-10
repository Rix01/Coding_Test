n = int(input())
# n*n 배열열
dp = [[0 for _ in range(n)] for _ in range(n)]
triangle = []

for i in range(n):
    triangle.append(list(map(int, input().split())))

dp[0][0] = triangle[0][0]

for i in range(1, n):
    for j in range(0, i+1):
        if j==0:
            dp[i][0] = dp[i-1][0] + triangle[i][0]
        if j==i:
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]
        dp[i][j] = max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j])

# 마지막 줄에서 제일 큰 수
dp_max = max(dp[n-1])

print(dp_max)