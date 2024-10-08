def solution(arr1, arr2):
    len_r = len(arr1)   # 행 길이
    len_c = len(arr1[0])    # 열 길이
    # 행렬 크기만큼 0으로 초기화된 2차원 배열 생성.
    # 그냥 [[]] 이렇게 하면 에러 남.
    answer = [[0] * len_c for _ in range(len_r)]
    
    for r in range(len_r):
        for c in range(len_c):
            answer[r][c] = arr1[r][c] + arr2[r][c]
    
    return answer