# https://app.codesignal.com/challenge/6nrk2rLGZRkH9gDZ5

def jumpingJimmy(t,j):
    s=0
    for h in t:
        if h<=j:
            s+=h
        else:
            break

    return s
