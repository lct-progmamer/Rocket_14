import cv2
import numpy as np



img = cv2.imread('vantay.jpg')
cv2.imshow('original' ,img )

# hàm phát hiện cạnh của vật thể trong ảnh , điều chỉnh 2 tham số cho hợp lí, nếu ko sẽ làm mất vật thể.
img2 = cv2.Canny(img , 100 , 200)


cv2.imshow('cannied' , img2)



cv2.waitKey()
cv2.destroyAllWindows()

