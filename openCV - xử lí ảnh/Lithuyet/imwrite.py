import cv2
import os

img = cv2.imread('gray.jpg') # khai báo ảnh ban đầu trong tệp

# đọc địa chỉ tệp để lưu ảnh
directory = r'C:\Users\Tai\Desktop\code\python\openCV - xử lí ảnh\save imwrite'


# đọc địa chỉ những ảnh có trong tệp
os.chdir(directory)
# in ra địa chỉ đó
print(os.listdir(directory))



#gán địa chỉ ảnh cần lưu vào tệp
file_name = 'hihi.jpg'
#lưu ảnh vào tệp
cv2.imwrite(file_name , img)

cv2.waitKey(0)
cv2.destroyAllWindows()
#đọc các địa chỉ ảnh có trong tệp
print(os.listdir(directory))