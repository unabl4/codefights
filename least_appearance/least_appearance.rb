# https://codefights.com/challenge/vvaEwn4NbpLYGMt5G

def leastAppearance(choices)
    h = Hash.new(0) # frequency counter
    
    choices.map do |choice|
        a,b = choice.map { |c| h[c] }
        if a == b
            v = choice.min
        elsif a < b
            v = choice[0]
        else # a > b
            v = choice[1]
        end
        
        h[v] += 1 # update freq
        v
    end
end

