scores = input("Scores: ")
print("********Report********")
history, math, computation = scores.split()
total = int(history)+int(math)+int(computation)
avg = total//3

print("History: {:>13}".format(history))
print("Mathematics: {:>9}".format(math))
print("Computation: {:>9}".format(computation))
print("----------------------")
print("Total Score: {:9}".format(total))
print("Average Score: {:7}".format(avg))