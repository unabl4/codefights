# https://app.codesignal.com/challenge/fBMqpka3pvk9jSHXp

import re
def wailingGhosts(s):
    z=re.findall(r'((o+)u+\2)',s)
    return ''.join(map(lambda x: x[0],z)) == s
