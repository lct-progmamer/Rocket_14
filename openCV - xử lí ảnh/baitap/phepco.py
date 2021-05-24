import numpy as np
import cv2



a = np.array([[0,0,0,0,0,0,0,0] , [0,0,0,1,1,1,1,0] , [0,0,0,1,1,1,1,0],
	[0,1,1,1,1,1,1,0],[0,1,1,1,1,1,1,0],[0,1,1,1,1,0,0,0]
	,[0,1,1,1,1,0,0,0],[0,0,0,0,0,0,0,0]])

b = np.array([[0,1,0] , [1,1,1] , [0,1,1]])
# print(a)
# print(b)


c = cv2.erode(a,b,iterations = 1)
# if cv2.waitKey() == ord('q'):
	# print(c)
cv2.waitKey()
cv2.destroyAllWindows()
