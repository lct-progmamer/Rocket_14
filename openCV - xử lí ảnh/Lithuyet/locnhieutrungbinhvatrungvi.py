import cv2

img0 = cv2.imread('anhnhieu.jpg')
img = cv2.resize(img0 , (500,500))



cv2.imshow("original",img)
cv2.waitKey()

#lọc trung bình 
img2 = cv2.blur(img, (3,3)) 
#lọc trung vị , số 5 là số phần tử được xét trong 1 lần tính.(sách xử lí ảnh trang 62)
img3 = cv2.medianBlur(img , 5)




cv2.imshow('loc trung binh',img2)
cv2.imshow('loc trung vi',img3)





cv2.waitKey()
cv2.destroyAllWindows()