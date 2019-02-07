# https://app.codesignal.com/challenge/ajSesXvQbhEoayaxR

def stolenLunch(note):
    s = ""
    for c in note:
        o = ord(c)
        if 48 <= o <= 57:
            # digit -> letter
            s += chr(o+49)
        elif 97 <= o <= 106:
            # letter -> digit
            s += chr(o-49)
        else:
            # non-convertable
            s += c
    
    return s
