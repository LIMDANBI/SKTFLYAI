num = int(input("구구단 입력: "))
width = int(input("가로 항목 수: "))
for i in range(1, 10):
    print("{:02d} x {:02d} = {:02d}".format(num, i, num*i), end='    ')
    if i%width==0:
        print()