import cv2

#cách 1: đọc ảnh, thêm tham số 0 để đọc ảnh xám
img = cv2.imread('erode.png',1)


cv2.imshow('original' , img)
cv2.waitKey()


# tham số 1 là hình ảnh chuyển xám , tham số 2 là thuộc tính chuyển từ ảnh màu BGR sang ảnh xám gray
img2  = cv2.cvtColor(img , cv2.COLOR_BGR2GRAY)

cv2.imshow('converted image',img2)

cv2.waitKey()
cv2.destroyAllWindows()


