# https://codefights.com/challenge/SfdjmLKbQQ7v48aCe

def fifthBitA2PlusB2(a,b)
    ((a**2 + b**2) & (1 << 5)) >> 5
end

