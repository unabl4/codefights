# https://app.codesignal.com/challenge/u8fmjEnYDRp3kZ2tt

# I aint optimizing a thing over here
d = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]

def howManySundays(n,s):
    i = d.index(s)
    return sum((i+j)%7 == 0 for j in range(1,n+1))
