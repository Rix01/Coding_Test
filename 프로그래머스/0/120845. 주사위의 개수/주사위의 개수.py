def solution(box, n):
    box[0] = box[0]//n
    box[1] = box[1]//n
    box[2] = box[2]//n
    answer = box[0]*box[1]*box[2]
    return answer