# https://app.codesignal.com/challenge/JtE3mNB44SyoTGaYi

def splitByValue(k,e):
    a = []
    b = []
    
    for i in e:
        if i < k:
            a.append(i)
        else:
            b.append(i)
    
    return a+b
