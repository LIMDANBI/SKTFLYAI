import numpy as np
import cv2
import utils

FILE_NAME = "trained.npz"


# def check(test, train, train_labels):
#     ret, result, neighbours, dist = knn.findNearest(test, k=5)
#     return result

def check_svm(test):
    return svm.predict(test)

def check_knn(test):
    ret, result, neighbours, dist = knn.findNearest(test, k=5)
    return result

def get_result(file_name, algorithm):
    image = cv2.imread(file_name)
    chars = utils.extract_chars(image)
    result_string = ""

    for char in chars:
        if algorithm=="svm":
            matched = check_svm(utils.resize20(char[1]))
            matched = matched[1][0][0]
        elif algorithm=="knn":
            matched = check_knn(utils.resize20(char[1]))
        if matched < 10:
            result_string += str(int(matched))
            continue
        if matched == 10:
            matched = '+'
        elif matched == 11:
            matched = '-'
        elif matched == 12:
            matched = '*'
        result_string +=matched
    return result_string

######################################################
#######################main##########################
####################################################
with np.load(FILE_NAME) as data:
    train = data['train']
    train_labels = data['train_labels']


############ knn ################
knn = cv2.ml.KNearest_create()
knn.train(train, cv2.ml.ROW_SAMPLE, train_labels)

############ svm ################
svm = cv2.ml.SVM_create()
svm.setType(cv2.ml.SVM_C_SVC) # c 파라미터
svm.setC(2.67)
svm.setGamma(5.383)
# svm.setKernel(cv2.ml.SVM_RBF) # Gamma 파라미터
svm.train(train, cv2.ml.ROW_SAMPLE, train_labels)
svm.save('svm_data.dat')

for i in range(31):
    print("knn: ", get_result("./tests/{}.png".format(i), "knn"))
    print("svm: ", get_result("./tests/{}.png".format(i), "svm"))
    print()