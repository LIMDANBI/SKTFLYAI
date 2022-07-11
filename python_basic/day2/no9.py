name = input("이름: ")
num = input("주민등록번호: ")

front, back = num.split('-')
year, gender = front[:2], ""

if back[0]=='1' or back[0]=='2':
    year = "19"+year
else:
    year = "20"+year

if back[0]=='1' or back[0]=='3':
    gender = "남"
else:
    gender = "여"

print("{}: {}년생 {}성".format(name, year, gender))