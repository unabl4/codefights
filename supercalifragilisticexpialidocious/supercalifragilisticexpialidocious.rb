# https://codefights.com/challenge/eFp6JjukccMGm7WvC

def method_missing x,s
    (0..33).select { |y| x[y] == s }
end
