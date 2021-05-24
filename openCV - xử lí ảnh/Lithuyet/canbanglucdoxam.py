import cv2
import numpy as np
from matplotlib import pyplot as plt 

img = cv2.imread('anhxamtoi.jpg',0)
cv2.imshow('original' , img)
plt.hist(img.ravel() , 256 , [0,256])
plt.show()
img2 = cv2.equalizeHist(img)
cv2.imshow('anh da can bang',img2)
plt.hist(img2.ravel() , 256 , [0,256])
plt.show()

cv2.waitKey()
cv2.destroyAllWindows()