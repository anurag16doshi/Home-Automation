import json
import urllib
import urllib.request
import random
usr = ""
count = 0
MWS = 0
SPGen = 0
SolarPGen = 0
Gen1stat = ""
SPGstat = ""
MWSstr = ""
SPGenstr=""
def powergen():
    global MWS
    global SolarPGen
    global Gen1stat
    global SPGstat
    global usr
    global MWSstr
    global SPGenstr
    if MWS!=0:
        url = url = "http://192.168.0.6/dbother/getdata1.php"
        z= urllib.request.urlopen(url)
        raw1_data = z.read()
        en1 = z.info().get_content_charset('utf-8') 
        dat = json.loads(raw1_data.decode(en1))
        for items in dat:
            M1 = dat['MWS']
            MWS = int(M1)
    if SPGen != 0:
        url = "http://192.168.0.6/dbother/getdata1.php"
        z= urllib.request.urlopen(url)
        raw1_data = z.read()
        en1 = z.info().get_content_charset('utf-8') 
        dat = json.loads(raw1_data.decode(en1))
        for items in dat:          
            SPGval = dat['SPGval']
            SolarPGen = int(SPGval)
    url = "http://192.168.0.6/dbother/getdata1.php"
    z= urllib.request.urlopen(url)
    raw1_data = z.read()
    en1 = z.info().get_content_charset('utf-8') 
    dat = json.loads(raw1_data.decode(en1))
    for items in dat:
        Gen1stat = dat['Gen1']
        SPGstat = dat['SPG']
        usr = dat['username']
    if(SPGstat == "OFF"):
        for x in range(2):
            SPGenstr = str(0)
    else:
        SolarPGen += random.randint(1,3)
        SPGenstr = str(SolarPGen)
    if(Gen1stat == "OFF"):
        for x in range(2):
            MWSstr = str(0)
    else:
        MWS += random.randint(1,3)
        MWSstr = str(MWS)
    
    data = [('username', usr),('MWS',MWSstr),('SPGenstr',SPGenstr)]
    data = urllib.parse.urlencode(data).encode("UTF-8")
    page = urllib.request.urlopen("http://192.168.0.6/dbother/add_data1.php", data).read()

while (count<9):    
    powergen()
    count = count + 1
    if count == 8:
        count = 0          

