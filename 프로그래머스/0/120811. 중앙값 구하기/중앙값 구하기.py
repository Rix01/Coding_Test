def solution(array):
    # 일단 정렬
    array.sort()
    
    center = len(array)//2
    
    answer = array[center]
    return answer