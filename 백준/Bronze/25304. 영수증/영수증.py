x = int(input())
n = int(input())
recipt = [0]*n

total = 0
for i in range(n):
    a, b = map(int, input().split())
    total += a*b

if(total==x):
    print("Yes")
else:
    print("No")

