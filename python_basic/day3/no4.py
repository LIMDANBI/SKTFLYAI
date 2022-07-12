import datetime as dt
dates = input("기준 날짜 (yyyy/mm/dd): ").split('/')
over = int(input("지나간 날수 (일): "))
y = int(dates[0])
m = int(dates[1])
d = int(dates[2])
newday = dt.date(y, m, d)+dt.timedelta(days=over)
print("{}년 {}월 {}일부터 {}일 후는 {}년 {}월 {}일".format(y, m, d, over, newday.year, newday.month, newday.day))