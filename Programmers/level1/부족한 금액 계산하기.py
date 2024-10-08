def solution(price, money, count):
    # count만큼 for문 돌리자 우선.
    need = 0    # 필요한 돈
    for i in range(1, count+1):
        need += price * i
    # 금액이 부족하지 않으면 0 리턴. 무조건. 즉, answer가 음수이면 0리턴이네.
    answer = need - money
    if(answer < 0): return 0

    return answer