import sys
input = sys.stdin.readline

n = int(input())

strNum = input().strip()

sum = 0
for i in range(n):
    sum += int(strNum[i])

print(sum)