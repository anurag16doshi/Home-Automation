import time
import datetime
import urllib
import urllib.request
import json

count=0
value1 = ""
value2 = ""

def schedule():
    
    global value1
    global value2
    now = datetime.datetime.now()
    hour = str(now.hour)
    minute = str(now.minute)
    year = str(now.year)
    month = str(now.month)
    day = str(now.day)
    second = str(now.second)
    
    t1 = hour + ":" + minute
    
    url1 = "http://192.168.0.3/dbother/scheduling.php"
    y = urllib.request.urlopen(url1)
    raw_data = y.read()
    enc = y.info().get_content_charset("utf-8")
    data = json.loads(raw_data.decode(enc))

    for items in data:
        if data['On'] == t1 :
            value1 = data['Apl']+" is scheduled ON for user = "+ data['username']
        if t1 == data['Off'] :
            value1 = data['Apl']+" is scheduled OFF for user = "+ data['username']
    time.sleep(1)
    
    for items in data:
        if data['On'] == t1 :
            value2 = data['Apl']+" is scheduled ON for user = "+ data['username']        
        if t1 == data['Off'] :
            value2 = data['Apl']+" is scheduled OFF for user = "+ data['username']
    
    if(value1 == value2):
        print(value1)
    else:
        print(value2)
    
while(count<10):
    schedule()
    count=1
