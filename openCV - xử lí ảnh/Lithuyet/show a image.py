import cv2
# path = r'C:\Users\Tai\Desktop\code\python\openCV - xử lí ảnh\hihi.jpg'

img = cv2.imread('hihi.jpg')

cv2.imshow('image' , img)

cv2.waitKey(0)
cv2.destroyAllWindows()
