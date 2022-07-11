register = set(input("수강 과목: ").split())
absent = set(input("결석한 과목: ").split())
not_submit = set(input("과제 미제출 과목: ").split())

print("A 예상 과목: {}".format(register-(absent|not_submit)))
print("F 예상 과목: {}".format(absent&not_submit))