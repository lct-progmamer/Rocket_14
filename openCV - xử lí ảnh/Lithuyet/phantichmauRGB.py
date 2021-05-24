import cv2


a = cv2.imread('RGB_paint.png')

cv2.imshow('original',a)

B,G,R = cv2.split(a) # tách các thành phàn màu RGB trong ảnh
# có màu gì sẽ nhạt hơn các thành phần khác


cv2.imshow('blue' , B)
# cv2.waitKey(0)

cv2.imshow('Green' , G)
# cv2.waitKey(0)

cv2.imshow('Red' , R)
cv2.waitKey(0)


cv2.destroyAllWindows()