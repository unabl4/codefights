# https://app.codesignal.com/challenge/5gPLgp4nMtMHZ8JJF

# I must say, I've spent more time than I should have on this 'easy' challenge
def clockHandAngle(t):
    h,m,s = map(int, t.split(':'))
    h = 0 if h == 12 else h
    md = 6*m + (6*s/60)
    hd = 30*h + (30*(m+s/60)/60)
    diff = abs(hd-md)
    return min(diff, 360-diff)
