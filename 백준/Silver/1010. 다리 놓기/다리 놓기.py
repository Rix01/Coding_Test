t = int(input())

dp =[[0 for _ in range(30)] for _ in range(30)]

# n=1일 때 M개
for i in range(30):
    dp[1][i]=i

for n in range(2, 30):
    for m in range(1, 30):
        dp[n][m] = dp[n][m-1] + dp[n-1][m-1]

for i in range(t):
    n, m = map(int, input().split())
    print(dp[n][m])