today = input("오늘 날짜를 입력하시오: ")
year, month, day = today.split('/')
if month[0] == '0':
    month = month[1]
if day[0] == '0':
    day = day[1]
print(year+'년', month+'월', day+'일')
