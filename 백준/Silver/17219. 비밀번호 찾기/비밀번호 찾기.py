n, m = map(int, input().split())

pwdDict = {}
answer = []

for i in range(n):
    site, pwd = map(str, input().split())
    pwdDict[site] = pwd

for s in range(m):
    findPwd = input()
    answer.append(pwdDict[findPwd])

for a in answer:
    print(a)