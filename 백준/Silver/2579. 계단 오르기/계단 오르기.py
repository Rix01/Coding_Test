n = int(input())
stairs = [0] * 301
dp = [0]*(n+1)

# 1. n-1과 연속일 때
# dp[n] = dp[n-3] + stairs[n-1] + stairs[n]

# 2. 연속 아닐 때
# dp[n] = dp[n-2] + stairs[n]

# 둘이 합치면
# dp[n] = max(dp[n-3] + stairs[n-1] + stairs[n], dp[n-2] + stairs[n])

for i in range(1, n+1):
    stairs[i] = int(input())

if n>=1:
    dp[1] = stairs[1]
if n>=2:
    dp[2] = stairs[1] + stairs[2]

if(n>=3):
    for i in range(3, n+1):
        dp[i] = max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2] + stairs[i])

print(dp[n])