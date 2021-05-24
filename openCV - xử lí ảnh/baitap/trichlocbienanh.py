import cv2
import numpy as np

img = cv2.imread('vantay.jpg')
matrix_b = np.ones((3,3) , np.uint8)

cv2.imshow('original' , img)


# sử dụng công thức để tìm biên ảnh : 
# print(matrix_b)
img2 = cv2.erode(img , (matrix_b) , iterations = 1)

img3 = img - img2

if cv2.waitKey()==ord('q'):
	cv2.imshow('anh bien' , img3)

# sử dụng hàm Canny để tìm biên ảnh:
# img2 = cv2.Canny(img , 100 , 200)
# if cv2.waitKey()==ord('q'):
# 	cv2.imshow('anh bien' , img2)



cv2.waitKey()
cv2.destroyAllWindows()