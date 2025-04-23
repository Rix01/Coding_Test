import sys
input = sys.stdin.readline

s = list(input().strip())
t = list(input().strip())

judge = len(t) - len(s)

# t에서 거꾸로 s가 가능한지 여부 판단
for _ in range(judge):
    if t[-1] == 'A':
        t.pop()
    elif t[-1] == 'B':
        t.pop()
        t.reverse()
if s == t:
    print(1)

else:
    print(0)
