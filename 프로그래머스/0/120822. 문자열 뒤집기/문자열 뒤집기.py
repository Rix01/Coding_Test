def solution(my_string):
    strLen = len(my_string)
    answer = ""
    for i in my_string[strLen-1::-1]:
        answer += i

    return answer