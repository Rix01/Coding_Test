n, m = map(int, input().split())
setN = set()
setM = set()

for i in range(n):
    str = input()
    setN.add(str)

for j in range(m):
    str = input()
    setM.add(str)

# 교집합
setRes = setN & setM
setToList = sorted(list(setRes))

print(len(setToList))
for i in setToList:
    print(i, end='\n')
