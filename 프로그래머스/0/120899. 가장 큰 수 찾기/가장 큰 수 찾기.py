def solution(array):
    answer = []
    max_num = max(array)
    max_idx = array.index(max(array))
    answer.append(max_num)
    answer.append(max_idx)
            
    return answer