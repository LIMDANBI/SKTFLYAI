expression = input("Expression: ").split('+')
ans = 0
for exp in expression:
    exp = exp.strip()
    e = exp.split('*')
    mat = 1
    for num in e:
        mat*=int(num)
    ans+=mat
print("Answer: {}".format(ans))