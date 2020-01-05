from __future__ import print_function
import argparse
import math
import cv2
import time
import numpy as np

# construct the argument parse and parse the arguments
ap = argparse.ArgumentParser()
ap.add_argument("-s","--sec",required=True,
    help = "Seconds to display on the clock")
ap.add_argument("-m","--min",required=True,
    help = "Minutes to display on the clock")
ap.add_argument("-hr","--hour",required=True,
    help = "Hours to display on the clock")
time = vars(ap.parse_args())

# save the values from the arguments into variables 
secs = float(time["sec"])
mins = float(time["min"])
hrs = float(time["hour"])

print(time)

# Calculate the angle displacement for each of the hands 
# relative from the 12 o'clock position

# second hand moves same as minute hand
sec_angle = 360 * (secs % 60)/60.0

# 60 min in a cycle, from 0-360
# min_angle = minute conversion + second offset
min_angle = 360 * (mins % 60)/60.0 + (sec_angle)*(1/60.0)

# hour hand moves around from 0-12 and is constrained. 12 hours in 1 cycle
# hrs angle = hour conversion + minute hand offset
hr_angle = 360 * (hrs % 12) / 12 + (min_angle)*(1/12.0)

print([sec_angle,min_angle,hr_angle])
sec_angle *= math.pi/180
min_angle *= math.pi/180
hr_angle *= math.pi/180

# draw the clock on the screen using cv2
canvas = np.zeros((300,300,3),dtype="uint8")
white = (255,255,255)
cv2.circle(canvas, (150,150), 100, white)

r_sec = 75.0
sec_vec = [r_sec*math.cos(sec_angle-math.pi/2),r_sec*math.sin(sec_angle-math.pi/2)]
cv2.line(canvas, (150,150),(150+int(sec_vec[0]),150+int(sec_vec[1])), white, 2)

r_min = 80.0
min_vec = [r_min*math.cos(min_angle-math.pi/2),r_min*math.sin(min_angle-math.pi/2)]
cv2.line(canvas, (150,150),(150+int(min_vec[0]),150+int(min_vec[1])), white, 3)

r_hr = 70.0
hr_vec = [r_hr*math.cos(hr_angle-math.pi/2),r_hr*math.sin(hr_angle-math.pi/2)]
cv2.line(canvas, (150,150),(150+int(hr_vec[0]),150+int(hr_vec[1])), white, 4)

cv2.imshow("Clock", canvas)
cv2.waitKey(0)
