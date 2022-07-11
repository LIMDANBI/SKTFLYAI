li = list(map(int, input("Enter 5 integers: ").split()))
print(li)
avg = sum(li)/len(li)
print("평균: {}".format(round(avg, 1)))