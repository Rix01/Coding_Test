n = int(input())
companyLog = {}

for i in range(n):
    worker, state = map(str, input().split())
    companyLog[worker] = state

# 사전식 정렬 역순
sortCompanyLog = dict(sorted(companyLog.items(), key= lambda x:x[0], reverse=True))

for k, v in sortCompanyLog.items():
    if v == "enter":
        print(k)