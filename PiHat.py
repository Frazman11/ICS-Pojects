#!/usr/bin/python


import RPi.GPIO as GPIO
import time


BUTTON1 = 17
BUTTON2 = 25
DELAY = 100 
TIMEOUT = 60
YELLOW = 27
RED = 18
GREEN = 22
num = 0

#use BCM method to identify pin numbers
GPIO.setmode(GPIO.BCM)
#inform the pi that pin27 yellow will be used for output
GPIO.setup(YELLOW, GPIO.OUT)
GPIO.setup(RED, GPIO.OUT)
GPIO.setup(GREEN, GPIO.OUT)

def button1_pressed(channel):
	global num 
	num = num+1
	print(num)
	if(num%2 == 0):
		GPIO.output(GREEN, 1)
		
		GPIO.output(RED, 0)
		
	if(num%2 != 0):
		GPIO.output(RED, 1)
		
		GPIO.output(GREEN, 0)
	if(num&num-1 == 0):
		GPIO.output(YELLOW, 1)
	else:
		GPIO.output(YELLOW, 0)
		
		
	    
def button2_pressed(channel):
	GPIO.output(RED, 1)   
	global num
	num = 0
	print(num)




GPIO.setup(BUTTON1, GPIO.IN)
#inform that button1pressed should be called as the circuit voltage rises due to the button 1 press
#to guard against errant calls wait for a given delay to let the voltage levels stabilize
GPIO.add_event_detect(BUTTON1, GPIO.RISING, callback = button1_pressed, bouncetime = DELAY)
#inform the pi that pin 25 (button 2) will be used for input
GPIO.setup(BUTTON2, GPIO.IN)
#inform that button2pressed should be called as the circuit voltage rises due to the button 2 press
GPIO.add_event_detect(BUTTON2, GPIO.RISING, callback = button2_pressed, bouncetime = DELAY)

time.sleep(TIMEOUT)
GPIO.output(YELLOW, 0)
GPIO.output(RED, 0)
GPIO.output(GREEN, 0)
GPIO.cleanup()
