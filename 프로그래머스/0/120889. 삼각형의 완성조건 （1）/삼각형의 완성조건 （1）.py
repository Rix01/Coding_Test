def solution(sides):
    # 일단 정렬
    sides.sort()
    if((sides[0]+sides[1])>sides[2]):
        return 1
    else:
        return 2