# https://app.codesignal.com/challenge/oHHb2WWoMkYSGEPbx

def newNumeralSystem(n):
    r = []
    for i in range(26):
        for j in range(i,26):
            if i+j == ord(n)-65:
                s = "%s + %s" % (chr(i+65),chr(j+65))
                r.append(s)
                
    return r
