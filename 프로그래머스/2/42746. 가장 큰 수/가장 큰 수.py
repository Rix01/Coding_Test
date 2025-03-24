def solution(numbers):
    numberStr = []
    
    for i in numbers:
        # 숫자를 문자열로 바꾸기
        numberStr.append(str(i))
    
    # 정렬 기준
    # 1. 맨 앞 자리 기준
    # 2. 30 3 34 이런 식으로 있을 때 3이 30보다 앞에 있기 위해서는
        # 자릿수가 작은 경우 33 이런 식으로 되게 해야 함. => 자릿수 맞춰줘야 한다는 소리.
        # 문제 제한 조건 보면 원소는 1000이하임. 
        # 따라서 3자리 수까지만 맞춰주면 됨.
        # 999 990 900 9 => 999 9 990 900 순으로 정렬될 것임.
        # 즉, 각 숫자마다 *3 해주면 한 자리수가 3자리가 되니까 비교 가능해짐.
    numberStr = sorted(numberStr, key=lambda x:x*3, reverse=True)

    # 정렬 순서대로 join
    # answer = ''.join(numberStr)로 하면 0,0,0과 같은 경우 000으로 반환됨.
    # 따라서 int로 감쌌다가 str로 다시 형변환 해야 함
    answer = str(int(''.join(numberStr)))
    return answer

numbers = [34, 31, 35, 3, 30]
print(solution(numbers))