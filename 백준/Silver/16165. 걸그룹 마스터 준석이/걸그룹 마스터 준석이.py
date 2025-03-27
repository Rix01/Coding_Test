n, m = map(int, input().split())
quizDict = {}

for i in range(n):
    team = input()
    memberN = int(input())
    members = []
    # 개인이면
    if(memberN==1):
        members.append(input())
    else:
        for j in range(memberN):
            members.append(input())
    members.sort()  # 사전식 정렬
    quizDict[team] = members    # 해시에 넣기

# 문제
for q in range(m):
    quiz = input()
    quizType = int(input())
    if(quizType==0):
        for member in quizDict[quiz]:
            print(member)
    elif(quizType==1):
        for k, v in quizDict.items():
            if(quiz in v):
                print(k)