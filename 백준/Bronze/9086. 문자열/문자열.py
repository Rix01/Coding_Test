# 민창 오빠의 풀이
num = input()
a = []
for i in range(0,int(num),1):
    words = input()
    a.append(words)

for j in a:
    print(j[0]+j[-1])

