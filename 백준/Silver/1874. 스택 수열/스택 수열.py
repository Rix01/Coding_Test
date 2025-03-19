n = int(input())
inputList = [0]*n
stackList = [1]
result = ['+']

for i in range(n):
    inputList[i] = int(input())

idx = 0
stackNum = 1
flag = 0
# 입력값 리스트 인덱스 < n 이면 반복
while(idx < n):
    now = stackList[-1] # 맨 뒤에. 스택으로 치면 맨 위
    if(now==inputList[idx]):
        idx+=1  # 리스트 다음 값 비교
        stackList.pop() # 값 꺼내기
        result.append('-')
        # 마지막에 stack 크기가 0이 되었을 때도 +가 되는 경우 발생
        # 따라서, stackNum 관련 조건도 추가.
        if(len(stackList)==0 and stackNum<n):
            stackNum+=1
            result.append('+')
            stackList.append(stackNum)
    else:
        stackNum += 1
        if(stackNum>n):
            flag = 1
            print("NO")
            break
        result.append('+')
        stackList.append(stackNum)

if flag==0:
    for i in result:
        print(i, end='\n')

