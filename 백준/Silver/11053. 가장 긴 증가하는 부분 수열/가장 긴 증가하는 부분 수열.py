import sys
input = sys.stdin.readline

n = int(input())
listA = list(map(int, input().split()))

dp = [1] * 1001
answer = 0
for i in range(n):
    for j in range(i):
        if(listA[j]<listA[i]):
            dp[i] = max(dp[j]+1, dp[i])

print(max(dp))