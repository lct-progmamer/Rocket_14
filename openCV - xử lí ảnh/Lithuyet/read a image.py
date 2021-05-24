import cv2 # import environment.	
img = cv2.imread('hihi.jpg') # read image
cv2.imshow('image',img) # show image

print(img) # show ảnh số


cv2.waitKey(0) # wait users to press any key
cv2.destroyAllWindows() # close all windows of program.