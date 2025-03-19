n = int(input())

result = 1
for i in range(1, n+1):
    result *= i

# 문자열로 변환
resultStr = str(result)

# 리스트로 변환 후 reverse
resultList = list(resultStr)
resultList.reverse()

cnt = 0
findZero = 0
for i in resultList:
    if(i=='0'):
        findZero=1
        cnt+=1
    # 0을 찾은 적이 없고 0이 아니면
    elif(findZero==0 and i!='0'):
        continue
    # 0을 찾은 적이 있고 0이 아니면
    elif(findZero==1 and i!='0'):
        break

print(cnt)