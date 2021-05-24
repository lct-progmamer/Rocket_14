import cv2
import numpy as np 
import imutils


img = cv2.imread('erode.png')
cv2.imshow('original',img)
cv2.waitKey()
#xoay ngược chiều kim đồng hồ , tham số thứ 2 là độ
img2 = imutils.rotate(img , 90)

cv2.imshow('rotated image',img2)

cv2.waitKey()
cv2.destroyAllWindows()