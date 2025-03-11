t = int(input())
dp = [0]*100

# 1 1 1 2 2 3 4 5 7 9 12 16 21... 순
dp[0] = 1
dp[1] = 1
dp[2] = 1

for i in range(3, 100):
    dp[i] = dp[i-3] + dp[i-2]

for i in range(t):
    n = int(input())
    print(dp[n-1])