# https://app.codesignal.com/challenge/xRhgADwiGi2Pm2qFx

def clockHandAngle2(a, t):
    e = 0.09 # it was 0.04 before; fuck I was so close.
    h,m,s = map(int, t.split(':'))
    while abs(angle(h,m,s)-a) > e:
        s += 1
        if s >= 60:
            m += 1
            s = 0 # reset
            
        if m >= 60:
            h += 1
            m = 0 # reset
    
        if h > 12:
            h -= 12
            
    return "%01d:%02d:%02d" % (h,m,s)

def angle(h,m,s):
    a = abs(30*h + 0.5*m + s/120.0 - (6*m+0.1*s))
    return min(a, 360-a)
