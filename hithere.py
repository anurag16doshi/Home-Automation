import datetime
import json
import urllib.request
import random

count = 0

SPGen = 0
Mws = 0

def Sensor():
    
    global Mws
    global SPGen    
    if (Mws!=0) :
        url = "http://192.168.0.6/dbother/send_valuesviewgen.php"
        z= urllib.request.urlopen(url)
        raw1_data = z.read()
        en1 = z.info().get_content_charset('utf-8') 
        dat = json.loads(raw1_data.decode(en1))
        for items in dat:
            M1 = dat['MWS']
            Mws = float(M1)
        
    url1 = "http://192.168.0.6/dbother/send_values.php"
    y = urllib.request.urlopen(url1)
    raw_data = y.read()
    enc = y.info().get_content_charset("utf-8")
    data = json.loads(raw_data.decode(enc))
    for items in data:
        if data['MainFloorLight'] == 'On':
            Mws = Mws + 0.1
            
        if data['Floor1Light'] == 'On':
            Mws = Mws + 0.1
            
        if data["MainFloorFan"] == 'Heat':
            Mws = Mws + 0.1
            
        if data["MainFloorFan"] == 'Cool':
            Mws = Mws + 0.1
            
        if data["Floor1Fan"] == 'Cool':
            Mws = Mws + 0.1
            
        if data["Floor1Fan"] == 'Heat':
            Mws = Mws + 0.1
            
        
            
            
    now = datetime.datetime.now()
    hour = str(now.hour)
    minute = str(now.minute)
    year = str(now.year)
    month = str(now.month)
    day = str(now.day)
    second = str(now.second)
    time = hour + ":" +minute + ":" + second
    date = month + ":" + day +":"+ year
    for x in range(2):
        SPGen += random.randint(1,3)
    SPGenstr = str(SPGen)
    MWSvalue = str(Mws)
    data = [('SPGenstr', SPGenstr) , ('username', data['username']),('date', date), ('time', time), ('MWS', MWSvalue)]
    data = urllib.parse.urlencode(data).encode("UTF-8")
    page = urllib.request.urlopen("http://192.168.0.6/dbother/add_data.php", data).read()
          
        
while (count<9):    
    Sensor()
    count = count + 1
    if count == 8:
        count = 0

