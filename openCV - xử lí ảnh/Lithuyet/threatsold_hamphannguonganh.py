import cv2
''' hàm này là hàm phân ngưỡng ảnh ,, giúp đưa ảnh về dạng nhị phân, tức ảnh đen trắng
chuyển tất cả các phần tử trong ảnh số về 2 dạng là 0 hoặc 255 tức là trắng hoặc đen


 đưa vào 1 giá trị threshold , hàm duyệt ma trận ảnh, phần tử nào lớn hơn threshold
 thì đc chuyển về 255
 còn bé hơn thì chuyển về 0
'''

img = cv2.imread('erode.png') 

#chuyển ảnh về ảnh xám
img2 = cv2.cvtColor(img , cv2.COLOR_BGR2GRAY)
# ret là giá trị trả về , các tham số bao gồm ảnh cần phân ngưỡng
# 127 là số thres đưa vào , 255 là số rảnh nếu phần tử  nào của ma trận lớn hơn 127 sẽ đc đưa về 255
# cv2...  là chế độ của hàm.
ret,img3 = cv2.threshold(img2, 120 , 255 , cv2.THRESH_BINARY)
cv2.waitKey()
cv2.imshow('hii',img3)




cv2.waitKey()
cv2.destroyAllWindows()
