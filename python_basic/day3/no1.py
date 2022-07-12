max_val = 0

def get_max(a, b):
    if a<b:
        return b
    else:
         return a

while True:
    num = int(input("양의 정수 입력: "))
    if num==0:
        print("프로그램을 종료합니다.")
        break
    max_val = get_max(max_val, num)
    print("현재까지 가장 큰 값: {}".format(max_val))