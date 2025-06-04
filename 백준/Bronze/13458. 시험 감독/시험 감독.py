import math
import sys
input = sys.stdin.readline

n = int(input())
tests = list(map(int, input().split()))

b, c = map(int, input().split())

res = len(tests)
for test in tests:
    test -= b
    if(test>=1):
        res += math.ceil((test/c))

print(res)