# https://codefights.com/challenge/jtbjBgG7Fhhn7S4Ac

# check if perfect root
def is_perfect?(n,d)
    root = n ** (1.0/d) # nth root
    (n-(root.round**d)).abs < 1e-9
end

def perfectSquareOrCube(number)
    # remove duplicate permutations
    perms = number.to_s.chars.permutation.uniq 
    perms.count do |digits|
        num = digits.join.to_i # new number
        is_perfect?(num,2) || is_perfect?(num,3)
    end
end

