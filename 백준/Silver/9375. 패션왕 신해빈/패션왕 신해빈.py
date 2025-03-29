n = int(input())

for i in range(n):
    cn = int(input())
    clothesDict = {}
    for j in range(cn):
        cloth, clothType = map(str, input().split())
        if(clothType in clothesDict):
            clothesDict[clothType].append(cloth)
        else:
            clothesDict[clothType] = [cloth]

    # 키 마다 값의 개수 + 1해서 곱하고 마지막에 -1 => 아무것도 안 입은 경우
    answer = 1
    for v in clothesDict.values():
        answer *= (len(v)+1)
    answer -= 1
    print(answer)