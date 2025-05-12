# 잔 선택 시, 모두 마셔야 함
# 연속 3잔 불가능 2잔까지만 가능

# 6, 10, 13, 9, 8, 1
# 6, 10, 9, 8 => 33

# 1. i번째 포도주 먹고 i-1번째 포도주도 먹음
# 2. i번째 포도주 먹고 i-1번째 안 먹음
# 3. i번째 포도주 안 먹음

import sys
input = sys.stdin.readline

n = int(input())
wine = [0]*10001
dp = [0]*10001

for i in range(n):
    wine[i] = int(input())

dp[0] = wine[0]
dp[1] = wine[0] + wine[1]
dp[2] = max(wine[2] + wine[1], wine[2] + wine[0], wine[0] + wine[1])

for i in range(3, n):
    dp[i] = max(wine[i]+wine[i-1]+dp[i-3], wine[i]+dp[i-2], dp[i-1])

print(dp[n-1])
