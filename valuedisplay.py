import datetime
import json
import urllib.request
import random
import time
i=0
def Show():
    count = 0
    hey = 0
    while(hey < 2):
        url1 = "http://192.168.0.3/dbother/send_values.php"
        y = urllib.request.urlopen(url1)
        raw_data = y.read()
        enc = y.info().get_content_charset("utf-8")
        data = json.loads(raw_data.decode(enc))
        for items in data:
            MainFloorLight = data['MainFloorLight']
            Floor1Light = data['Floor1Light']
            MainFloorFan = data['MainFloorFan']
            Floor1Fan = data['Floor1Fan']
            MainFloorTemp = data['MainFloorTemp']
            Floor1Temp = data['Floor1Temp']
            MainDoorLock = data['MainDoorLock']
            BackDoorLock = data['BackDoorLock']
            Garage1Lock = data['Garage1Lock']
            Garage2Lock = data['Garage2Lock']
            MMSStat = data['MMSStat']
            F1MSStat = data['F1MSStat']
            Washer = data['Washer']
            Dryer = data['Dryer']
            status = data['status']
        time.sleep(4)
        while(count<1):
            url1 = "http://192.168.0.3/dbother/send_values.php"
            y = urllib.request.urlopen(url1)
            raw_data = y.read()
            enc = y.info().get_content_charset("utf-8")
            data = json.loads(raw_data.decode(enc))
            if(data['MainFloorLight'] != MainFloorLight):
                print("MainFloorLight = "+data['MainFloorLight'])
            if(data['Floor1Light'] != Floor1Light):
                print("Floor1Light = "+data['Floor1Light'])
            if(data['MainFloorFan'] != MainFloorFan):
                print("MainFloorFan = "+data['MainFloorFan'])
            if(data['Floor1Fan'] != Floor1Fan):
                print("Floor1Fan = "+data['Floor1Fan'])
            if(data['Floor1Temp'] != Floor1Temp):
                print("Floor1Temp = "+data['Floor1Temp'])
            if(data['MainFloorTemp'] != MainFloorTemp):
                print("MainFloorTemp = "+data['MainFloorTemp'])
            if(data['Garage1Lock'] != Garage1Lock):
                print("Garage1 Door is "+data['Garage1Lock'])
            if(data['Garage2Lock'] != Garage2Lock):
                print("Garage2 Door is "+data['Garage2Lock'])
            if(data['MainDoorLock'] != MainDoorLock):
                print("Main Door is "+data['MainDoorLock'])
            if(data['BackDoorLock'] != BackDoorLock):
                print("Back Door is "+data['BackDoorLock'])
            if(data['MMSStat'] != MMSStat):
                print("MainFloorMotionSensor is "+ data['MMSStat'])
            if(data['F1MSStat'] != F1MSStat):
                print("Floor1MotionSensor is "+ data['F1MSStat'])
            if(data['Washer'] != Washer):
                print("The Washer is "+data['Washer'])
            if(data['Dryer'] != Dryer):
                print("The Dryer is "+data['Dryer'])
            if(data['status'] != status):
                print("The Security System status is = " + data['status'])
            count=count+1
                
        hey = 2
while(i<10):
    Show()
    i+=1
    if i == 9 :
        i=0

