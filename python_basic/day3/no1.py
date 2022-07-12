get_max = 0
while True:
    num = int(input("양의 정수 입력: "))
    if num==0:
        print("프로그램을 종료합니다.")
        break
    get_max = max(get_max, num)
    print("현재까지 가장 큰 값: {}".format(get_max))