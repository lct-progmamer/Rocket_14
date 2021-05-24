import cv2
import numpy as py

img = cv2.imread('erode.png')

cv2.imshow('original' , img)
cv2.waitKey()
#làm mờ ảnh  , giá trị () luôn là số dương và lẻ , càng số lớn thì càng mờ  , phần tử signalX cuối là độ lệch
img2 = cv2.GaussianBlur(img , (5,5),0)

cv2.imshow('lammo',img2)

cv2.waitKey()
cv2.destroyAllWindows()