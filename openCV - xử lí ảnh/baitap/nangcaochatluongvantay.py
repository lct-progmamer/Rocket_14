import cv2
import numpy as np 


img = cv2.imread('vantay.jpg')
cv2.imshow('original' , img)

matrix_b = np.ones((3,3) , np.uint8)


img2 = cv2.erode(img , (matrix_b) , iterations = 1)
img3 = cv2.dilate(img2 , (matrix_b),iterations = 1)
img4 = cv2.dilate(img3 , (matrix_b),iterations = 1)
img5 = cv2.erode(img4 , (matrix_b) , iterations = 1)


if cv2.waitKey()==ord('q'):
	cv2.imshow('nang cao',img5)

cv2.waitKey()
cv2.destroyAllWindows()