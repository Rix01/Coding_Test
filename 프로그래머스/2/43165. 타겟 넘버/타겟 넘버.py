def do_plus(calculate_array, calculate_number):
    for i in range(len(calculate_array)):
        calculate_array[i] += calculate_number

def do_minus(calculate_array, calculate_number):
    for i in range(len(calculate_array)):
        calculate_array[i] -= calculate_number

def solution(numbers, target):
    result = [0]
    for number in numbers:
        plus = result.copy()
        minus = result.copy()

        # 더하기
        do_plus(plus, number)
        # 빼기
        do_minus(minus, number)

        result = plus + minus
    # result에서 target 찾기
    count = result.count(target)
    return count