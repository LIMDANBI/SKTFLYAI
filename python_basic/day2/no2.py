li = []
total = 0
for _ in range(5):
    num = int(input("Enter 5 integers: "))
    total+=num
    li.append(num)
print(li)
print("평균: {}".format(round(total/len(li), 1)))