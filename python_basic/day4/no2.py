fname = input("Enter text file name: ")
word = input("Enter words: ")
fp = open(fname, 'r')
linenum = 0
for s in fp:
    linenum+=1
    if s.find(word)!=-1:
        print("({}) {}".format(linenum, s), end="")
fp.close()