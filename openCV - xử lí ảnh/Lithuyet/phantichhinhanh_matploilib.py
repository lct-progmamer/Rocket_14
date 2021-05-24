import cv2
from matplotlib import pyplot as plt 



img = cv2.imread('erode.png',0)

cv2.imshow('original' , img)
# vẽ lược xám thể hiện các gray level của ảnh.

# histogram = cv2.calcHist([img] , [0] , None , [256] , [0,256])
# plt.plot(histogram)
# plt.show()
plt.hist(img.ravel() , 256 , [0,256])
plt.show()

cv2.waitKey()
cv2.destroyAllWindows()
