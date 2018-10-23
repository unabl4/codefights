# https://app.codesignal.com/challenge/883TZQd7mNbt97GXt

z=(eval(dir()[0]))[0]
z.sort()
for a,b in zip(z[:-1], z[1:]): # each_cons(2)
    if b.startswith(a):
        return 0
return 1
