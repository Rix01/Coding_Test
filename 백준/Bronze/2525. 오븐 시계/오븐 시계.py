a, b = map(int, input().split())
c = int(input())

h = (b+c)//60
m = (b+c)%60

h = (a+h)%24

print(h, m)