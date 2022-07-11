word = input("문장: ").split()
total = 0
for w in word:
    w = w.strip()
    total+=len(w)
print("전체글자수:", total)
print("평균글자수:", round(total/4,1))
