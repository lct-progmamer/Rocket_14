import cv2

img = cv2.imread('hihi.jpg')


# cv2.imshow('image' , img) # show ảnh có size cũ
# cách 1 : dùng số tự chọn
image_size = cv2.resize(img, (500 , 500)) 
image_size1 = cv2.resize(img, dsize = (100, 100) )
image_size2 = cv2.resize(img, dsize = None, fx = 0.5, fy = 0.5)


cv2.imshow(' resize(pixel) x = 100 , y = 100', image_size)
cv2.imshow('tuong tu cai tren', image_size1)
cv2.imshow('resize', image_size2)
#cách 2 : dùng biến lưu số để thay đổi.
# new_height = 400
# new_width = 800
# image_size = cv2.resize(img, (new_width , new_height)) 
# image_size1 = cv2.resize(img, dsize =  (new_width , new_height) )


cv2.waitKey(0)
cv2.destroyAllWindows()
