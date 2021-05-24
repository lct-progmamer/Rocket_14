import cv2
import numpy as np

img = cv2.imread('anhxamtoi.jpg')

img2 = cv2.cvtColor(img , cv2.COLOR_BGR2GRAY)
cv2.imshow('original',img)

thresh1 = cv2.adaptiveThreshold(img2, 255, cv2.ADAPTIVE_THRESH_MEAN_C,cv2.THRESH_BINARY, 199, 5) 
# thuộc tính 1 là ảnh đầu vào
# thuộc tính 2 là giá trị lớn nhât có thể gán cho 1 pixel
#thuộc tính 3 là methodadaptive : phương pháp tính giá trị ngưỡng
# thuộc tính 4 là Loại ngưỡng áo dụng
#thuộc tính 5 là Kích thước của vùng lân cận pixel được sử dụng để tính giá trị ngưỡng.
#thuộc tính 6 là Một giá trị không đổi được trừ cho tổng trung bình hoặc tổng trọng số của các pixel lân cận.
  
  '''
 -	v2.ADAPTIVE_THRESH_MEAN_C : Threshold Value = (Giá trị trung bình của các giá trị khu vực lân cận - giá trị không đổi).
 Nói cách khác, nó là giá trị trung bình của vùng lân cận blockSize × blockSize của một điểm trừ hằng số.
 -	cv2.ADAPTIVE_THRESH_GAUSSIAN_C : Giá trị ngưỡng = (Tổng trọng số Gaussian của các giá trị lân cận - giá trị không đổi). 
  Nói cách khác, nó là tổng có trọng số của vùng lân cận blockSize × blockSize của một điểm trừ hằng số.
  '''
thresh2 = cv2.adaptiveThreshold(img2, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C,cv2.THRESH_BINARY, 199, 5) 

cv2.imshow('thesh_mean_c',thresh1)
cv2.imshow('thesh_gaussian_c' , thresh2)


cv2.waitKey()
cv2.destroyAllWindows()