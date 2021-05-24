import cv2
import numpy as np 


img = cv2.imread('erode.png')
cv2.waitKey()

#tạo đường biên , tham số 1 là ảnh cần tạo
# tham số 2 là đối số đưa vào để tạo độ dày của đường biên theo thứ tự _ trên , dưới , trái , phải
'''cv2.BORDER_CONSTANT: 
	Nó thêm một đường viền màu không đổi. Giá trị sẽ được đưa ra làm đối số tiếp theo.
cv2.BORDER_REFLECT: Đường viền sẽ là phản chiếu phản chiếu của các phần tử đường viền. Giả sử, nếu hình ảnh chứa các chữ cái “ abcdefg ” thì đầu ra sẽ là “ gfedcba | abcdefg | gfedcba “.
cv2.BORDER_REFLECT_101 hoặc cv2.BORDER_DEFAULT:
	 Nó hoạt động tương tự như cv2.BORDER_REFLECT nhưng có một chút thay đổi. Giả sử, nếu hình ảnh chứa các chữ cái “ abcdefgh ” thì đầu ra sẽ là “ gfedcb | abcdefgh | gfedcba “.
cv2.BORDER_REPLICATE: 
	Nó sao chép phần tử cuối cùng. Giả sử, nếu hình ảnh chứa các chữ cái “ abcdefgh”Thì đầu ra sẽ là“ aaaaa | abcdefgh | hhhhh “.

'''
img2 = cv2.copyMakeBorder(img , 50,50,50,50 , cv2.BORDER_CONSTANT)

cv2.imshow('anh_tao_border',img2)

cv2.waitKey()
cv2.destroyAllWindows()

