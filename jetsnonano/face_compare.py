import cv2
import face_recognition
img = cv2.imread("./young_gates.jpg")
rgb_img = cv2.cvtColor(img,	cv2.COLOR_BGR2RGB)
img_encoding = face_recognition.face_encodings(rgb_img)[0]

img2 = cv2.imread("./old_gates.jpg")
rgb_img2 = cv2.cvtColor(img2, cv2.COLOR_BGR2RGB)
img_encoding2 =	face_recognition.face_encodings(rgb_img2)[0]

img3 = cv2.imread("./mark.jpg")
rgb_img3 = cv2.cvtColor(img3, cv2.COLOR_BGR2RGB)
img_encoding3 =	face_recognition.face_encodings(rgb_img3)[0]

result = face_recognition.compare_faces([img_encoding2, img_encoding3],	img_encoding)
print("Result: ", result)
cv2.imshow("Img", img)
cv2.imshow("Img 2",	img2)
cv2.waitKey(0)