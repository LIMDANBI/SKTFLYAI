def int_list_input(*pr):
    nums = []
    if(len(pr)==0):
        nums = list(map(int, input().split()))
    else:    
        nums = list(map(int, input(pr[0]).split()))
    return nums

prompt = input("Input prompt: ") + ": "
int_list1 = int_list_input(prompt)
print(prompt, "=", int_list1)
print("Add numbers: ", end='')
int_list2 = int_list_input()
print("sum of", int_list2, "is", sum(int_list2))