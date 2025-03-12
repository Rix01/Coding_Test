n = int(input())
array = list(map(int, input().split()))
dp = [0]*n

dp[0] = array[0]
max_sum = dp[0]

for i in range(1, n):
    dp[i] = max(array[i], dp[i-1]+array[i])
    max_sum = max(max_sum, dp[i])

# print(dp)
print(max_sum)
