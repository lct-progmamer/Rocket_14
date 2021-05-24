import cv2
import numpy as np 
import imutils


img = cv2.imread('erode.png')
# cv2.imshow('original',img)
# cv2.waitKey()

rotate_num = int(input('nhập số độ quay ảnh : '))
#xoay ngược chiều kim đồng hồ , tham số thứ 2 là độ
img2 = imutils.rotate(img , rotate_num)

cv2.imshow('rotated image',img2)

cv2.waitKey()
cv2.destroyAllWindows()







