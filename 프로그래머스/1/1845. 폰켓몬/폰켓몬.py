def solution(nums):
    # 폰켓몬 개수 n
    n = len(nums)
    # 폰켓몬 종류 수 type_num
    type_num = len(set(nums))
    if((n//2)>=type_num):
        return type_num
    else:
        return (n//2)