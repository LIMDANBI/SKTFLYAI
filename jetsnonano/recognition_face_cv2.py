import face_recognition
import cv2

image_of_mark =	face_recognition.load_image_file('./mark.jpg')
mark_face_encoding = face_recognition.face_encodings(image_of_mark)[0]
image_of_gates = face_recognition.load_image_file('./old_gates.jpg')
gates_face_encoding = face_recognition.face_encodings(image_of_gates)[0]

# Create arrays of encodings and names
known_face_encodings =	[
    mark_face_encoding,
    gates_face_encoding,
]

known_face_names =	[
    "mark",	
    "gates",
]

# Load test image to find faces	in
test_image = face_recognition.load_image_file('./gates_mark_elon.jpg')

# Find faces in	test image

test_face_locations =	face_recognition.face_locations(test_image)
test_face_encodings =	face_recognition.face_encodings(test_image,	test_face_locations)
test_image = cv2.cvtColor(test_image, cv2.COLOR_BGR2RGB)

for(top, right, bottom, left),	test_face_encoding in zip(test_face_locations,	test_face_encodings):
    name =	"Unknown Person"
    matches = face_recognition.compare_faces(known_face_encodings,	test_face_encoding,	0.6)

    if True in matches:
        first_match_index =	matches.index(True)
    name =	known_face_names[first_match_index]
    cv2.rectangle(test_image, (left, top), (right,	bottom), (0,255,0),	2)
    cv2.rectangle(test_image, (left, top - 20),	(right,	top), (0, 255, 0), cv2.FILLED)
    cv2.putText(test_image,	name, (left+2, top-2), cv2.FONT_HERSHEY_SIMPLEX, 1, (0,0,0), 1)
cv2.imshow('myWindows',	test_image)
cv2.moveWindow('myWindows',	0,	0)

if cv2.waitKey(0)==ord('q'):
    cv2.destroyAllWindows()