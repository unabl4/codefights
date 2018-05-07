# https://codefights.com/challenge/ct2vZTL8N4urXaaSa

def bitRotate n,r
 n.to_s(2).rjust(31,'0').chars.rotate(r).join.to_i(2)
end

