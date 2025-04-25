def solution(cipher, code):
    answer = ''
    # 일단 cipher를 리스트로 변환
    cipherList = list(cipher)
    startIdx = code - 1 # 0부터 인덱스 시작이니
    for i in range(startIdx, len(cipherList), code):
        answer += cipherList[i]
    return answer