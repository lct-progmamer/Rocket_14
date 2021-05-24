import cv2
import numpy as np

img1 = cv2.imread('erode.png')
cv2.imshow('original',img1)

matrix_b = np.ones((5,5) , np.uint8)


img = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
cv2.imshow('Gray_Image' , img)
img3 = cv2.erode(img , (matrix_b) , iterations = 1)
cv2.imshow('erode' , img3)
img4 = cv2.dilate(img , (matrix_b) , iterations =1)
cv2.imshow('dilate' , img4)
img5 = cv2.dilate(img3 , (matrix_b) , iterations =1)
cv2.imshow('opening' , img5)
img6 = cv2.erode(img4 , (matrix_b) , iterations =1)
cv2.imshow('closing ',img6)
img7 = img - img3
cv2.imshow("border",img7)
cv2.waitKey()
cv2.destroyAllWindows()