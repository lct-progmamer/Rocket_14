import cv2
import numpy as np


img = cv2.imread('vantay.jpg')
cv2.imshow('original' , img)
matrix_b = np.ones((3,3) , np.uint8)
# print(matrix_b)
# tham số img là ảnh cần co , matix b là nhân quét , iterations là sự lặp lại n lần phép co
img2 = cv2.erode(img , (matrix_b) , iterations = 1)
cv2.imshow('image' , img2)


if cv2.waitKey(0)==ord('q'):
	cv2.destroyAllWindows()