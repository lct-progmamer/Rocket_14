import cv2
import matplotlib.pyplot as plt



img = cv2.imread('hihi.jpg')
img1 = cv2.resize(img, (500 , 500))

cv2.imshow('hihi' , img1)

#kiểm tra kích thước ảnh bằng x , y
plt.imshow(img1)
plt.show()

cv2.waitKey(0)
cv2.destroyAllWindows()
