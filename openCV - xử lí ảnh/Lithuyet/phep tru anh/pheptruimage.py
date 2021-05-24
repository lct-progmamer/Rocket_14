import cv2
import numpy as np



img1 = cv2.imread('pheptru1.jpg')
img2 = cv2.imread('pheptru2.jpg')

cv2.imshow('picture1' , img1)
cv2.imshow('picture2' , img2)
cv2.waitKey(0)



#hai picture phải có size bằng nhau!
img3 = cv2.subtract(img1 , img2)
cv2.imshow('ket qua' , img3)





cv2.waitKey(0)
cv2.destroyAllWindows()

