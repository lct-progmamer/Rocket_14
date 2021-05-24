import cv2  
import numpy as np  
    
# path to input images are specified and   
# images are loaded with imread command  
image1 = cv2.imread('hihi.jpg')  
image2 = cv2.imread('background.jpg') 
 
image3 = cv2.resize(image1 , (500,500))
image4 = cv2.resize(image2 , (500,500))
# cv2.addWeighted is applied over the 
# image inputs with applied parameters 
weightedSum = cv2.addWeighted(image3, 0.5, image4, 0.4, 0) 
  
# the window showing output image 
# with the weighted sum  
cv2.imshow('Weighted Image', weightedSum) 
  
# De-allocate any associated memory usage   
if cv2.waitKey(0) & 0xff == 27:  
    cv2.destroyAllWindows()  
