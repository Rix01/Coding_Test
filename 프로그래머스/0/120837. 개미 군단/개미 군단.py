def solution(hp):
    ants = [5,3,1]
    cnt = 0
    for power in ants:
        antCnt = hp//power
        hp -= power*antCnt
        cnt += antCnt
    return cnt