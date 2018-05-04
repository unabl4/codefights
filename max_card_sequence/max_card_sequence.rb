# https://codefights.com/challenge/kjXSxYfm4ZfvdzAs4

def maxCardSequence(cards)
    cards.sort! # sort
    
    l = 1
    s = cards[0] % 2
    n = cards.size # length
    (1...n).each do |idx|
        y = cards[idx] % 2
        if y != s
            s = y # memo
            l += 1
        end
    end
    
    l
end

