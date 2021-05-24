import cv2  
import numpy as np  
# import matplotlib.pyplot as plt    

image1 = cv2.imread('hihi.jpg')  
image2 = cv2.imread('background.jpg') 

new_height = 400
new_width = 800
 
image3 = cv2.resize(image1 , (new_width , new_height))
image4 = cv2.resize(image2 , (new_width , new_height))

cv2.imshow('picture1' , image3)
cv2.imshow('picture2' , image4)
cv2.waitKey()
# note : 2 ảnh phải có size bằng nhau
# các tham gia lần lượt là : hình ảnh backgound , giá trị mờ của nó , hình ảnh cộng thêm , giá trị mờ của nó , và độ sáng của ảnh
weightedSum = cv2.addWeighted(image3, 0.2, image4, 0.1, 0) 
  

cv2.imshow('Weighted Image', weightedSum) 
  

if cv2.waitKey(0) & 0xff == 27:  
    cv2.destroyAllWindows()  
