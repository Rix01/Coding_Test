n = int(input())
stairs = [0]
for _ in range(n):
    stairs.append(int(input()))

dp = [0 for _ in range(n+1)]
if n >= 1:
    dp[1] = stairs[1]
if n >= 2:
    dp[2] = stairs[1] + stairs[2]
if n>=3:
    for i in range(3, n+1):
        dp[i] = max(stairs[i-1] + stairs[i] + dp[i-3], dp[i - 2] + stairs[i])

print(dp[n])