import os
import cv2
import time

DATA_DIR = './data'
if not os.path.exists(DATA_DIR):
    os.makedirs(DATA_DIR)

num_img = 100
cap_key = 'c'
exit_key = 'q'
num_classes = 24
classes = ['A', 'B', 'C', 'D', 'E', 'F',
           'G', 'H', 'I', 'K', 'L', 'M',
           'N', 'O', 'P', 'Q', 'R', 'S',
           'T', 'U', 'V', 'W', 'X', 'Y'] 

cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("Error: Could not open webcam.")
    exit()

print(f"Press '{cap_key}' to begin capturing, '{exit_key}' to quit.")

count = 0

while count < len(classes):
    ret, frame = cap.read()
    if not ret:
        print("Failed to grab frame.")
        break

    cv2.imshow("Webcam - Press 'c' to capture", frame)

    key = cv2.waitKey(1) & 0xFF

    if key == ord(cap_key):
        print(f"Starting capturing ...")
        time.sleep(5)
        for j in range(num_img):
            ret, frame = cap.read()
            if not ret: 
                print("Failed to grab frame during capture.")
                break
            classdir = os.path.join(DATA_DIR, classes[count])
            if not os.path.exists(classdir):
                os.makedirs(classdir)
            filename = os.path.join(classdir, f"img{j+1}.jpg")
            success = cv2.imwrite(filename, frame)
            if success:
                print(f"Saved {filename}")
            else:
                print(f"Failed to save {filename}")
            time.sleep(0.2)
        print("Capture complete. Press 'c' to start another session or 'q' to quit.")
        count += 1
    
    elif key == ord(exit_key):
        print("Exiting.")
        break

cap.release()
cv2.destroyAllWindows()