sentence = input("문장: ")
word = list(sentence.split())
total = 0
length = len(word)
for w in word:
    total+=len(w)
print("위 문장의 단어 수는 {}개이며, 평균 글자 수는 {}개입니다.".format(length, round(total/length, 1)))