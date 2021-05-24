import cv2

# Bước 1: Tấm ảnh và tệp tin xml
face_cascade = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")
image_size2 = cv2.imread("bedat.jpg",1)
image = cv2.resize(image_size2, dsize = None, fx = 0.5, fy = 0.5)


# Bước 2: Tạo một bức ảnh xám
grayImage = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Bước 3: Tìm khuôn mặt
faces = face_cascade.detectMultiScale(
    grayImage,
    scaleFactor  = 1.1,
    minNeighbors = 5,
)

# Bước 4: Vẽ các khuôn mặt đã nhận diện được lên tấm ảnh gốc
for (x, y, w, h) in faces:
    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)

# Bước 5: Vẽ lên màn hình
cv2.imshow("Faces found", image)

cv2.waitKey(0)
cv2.destroyAllWindows()