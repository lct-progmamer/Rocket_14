import cv2
import numpy as np


img = cv2.imread('vantay.jpg')
cv2.imshow('original' , img)

matrix_b = np.ones((3,3) , np.uint8)

# tham số img là ảnh cần giãn , matix b là nhân quét , iterations là sự lặp lại n lần phép giãn
img2 = cv2.dilate(img ,matrix_b, iterations = 1)
cv2.imshow('dilated' ,img2)



cv2.waitKey()
cv2.destroyAllWindows()