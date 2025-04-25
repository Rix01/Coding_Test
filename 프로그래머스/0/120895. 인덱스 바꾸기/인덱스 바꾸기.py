def solution(my_string, num1, num2):
    answer = ''
    my_string = list(my_string)
    temp = my_string[num1]
    for i in range(len(my_string)):
        if i==num1:
            answer += my_string[num2]
            continue
        elif i==num2:
            answer+=temp
            continue
        answer+=my_string[i]
    return answer