def solution(clothes):
    # 종류별 수 세기 위한 딕셔너리
    clothes_cnt = dict()
    for type in clothes:
        # type[1]이 옷 종류 써있음.
        # 일단 이미 있는지 확인
        if(type[1] in clothes_cnt):
            clothes_cnt[type[1]] += 1
        else:
            clothes_cnt[type[1]] = 1
    
    cnt = 1
    for v in clothes_cnt.values():
        cnt *= (v+1)
    return cnt -1   # 아무것도 안 입은 경우는 제외