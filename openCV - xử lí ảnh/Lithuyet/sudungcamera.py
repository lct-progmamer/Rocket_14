import cv2

cap = cv2.VideoCapture(0)

while(0):
	_,frame = cap.read()
	cv2.imshow("capture" , frame)
	cv2.waitKey(0)
	
cv2.destroyAllWindows()
cap.release()