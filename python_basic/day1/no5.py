scores = input("Scores: ")
print("********Report********")
history, math, computation =scores.split()
total = int(history)+int(math)+int(computation)
avg = total//3

print("History:", end=''); print(history.rjust(14))
print("Mathematics:", end=''); print(math.rjust(10))
print("Computation:", end=''); print(computation.rjust(10))
print("----------------------")
print("Total Score:", end=''); print(str(total).rjust(10))
print("Average Score:", end=''); print(str(avg).rjust(8))
