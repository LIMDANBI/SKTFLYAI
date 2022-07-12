import random
import time

print("구구단 5문제 빨리풀기 테스트")
input("시작하려면 엔터키를 누루시오...")

cnt = 0
tStart = time.time()
for i in range(1,6):
    a = random.randint(1,9)
    b = random.randint(1,9)
    ans = input("({}) {} x {} = ".format(i, a, b))
    while not ans.isdigit():
        print("숫자를 입력하시오.")
        ans = input("({}) {} x {} = ".format(i, a, b))
    else:
        ans = int(ans)
    if ans==a*b:
        cnt+=1
        print("Correct!!!")
    else:
        print("Incorrect. Try again.")

tFinish = time.time()
tSolveTime = round(tFinish-tStart, 2)
print("{}문제 성공, 시간은 {}초 입니다.".format(cnt, tSolveTime))