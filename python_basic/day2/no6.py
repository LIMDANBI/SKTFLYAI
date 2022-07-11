phoneNum = list(input("전화번호: ").split('-'))
for i in phoneNum[2]:
    print("{} {}".format(i, '#'*int(i)))