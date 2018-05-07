# https://codefights.com/challenge/NNP7vjLFzC28hrXMR

# thank you, @breathermachine and @assaf_r for your help

# checks if die 'A' rolls higher/stronger than die 'B'
# 'a' - first die, 'b' - second die
def is_higher?(a,b)
    c = 0 # counter
    
    a.each do |x|
        b.each do |y|
            if x > y
                c += 1
            elsif x < y
                c -= 1
            end
        end
    end
    
    c > 0
end

def nontransitiveDice(dice)
    # try all possible combinations of three dices -> 6 possibilities
    dice.permutation.any? do |a,b,c|
        is_higher?(a,b) && is_higher?(b,c) && !is_higher?(a,c)
    end
end

