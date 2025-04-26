import sys
input = sys.stdin.readline

n = int(input())

dp = [0]*91
dp[1] = 1
dp[2] = 1

# 점화식 dp[n] = dp[n-1] + dp[n-2]

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[n])