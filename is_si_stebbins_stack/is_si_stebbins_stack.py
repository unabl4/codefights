# https://app.codesignal.com/challenge/x4EA5fMk3ZJa5vgTc

suits = 'CHSD' # Clubs, Hearts, Spades, Diamonds
values = ['A','2','3','4','5','6','7','8','9','10','J','Q','K']

def parse_card(card):
    index = suits.index(card[-1])
    value = values.index(card[:-1])
    return (value, index)

def isSiStebbinsStack(deck):
    cards = [parse_card(c) for c in deck.split()]    
    for i in range(1,len(cards)):
        prev_card = cards[i-1]
        curr_card = cards[i]
        
        # check suit
        if (curr_card[1]-prev_card[1]) % 4 != 1:
            return i+1
        
        # check the value difference to be equal to 3
        if (curr_card[0]-prev_card[0]) % 13 != 3:
            return i+1
    
    # Si Stibbens order => '1'
    return 1
