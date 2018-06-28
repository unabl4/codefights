# https://codefights.com/challenge/X6Lkshpxhd63W2Nzw

def referFriends(userInfo)
    h = Hash.new(0) # refs
    users = JSON.parse(userInfo)
    users.each do |user|
        ref = user['referrerId']
        h[ref] += 500 if ref # +500 USD
    end
    
    users.map do |user|
        amount = ['$', h[user['_id']]].join
        [user['username'], amount].join(' ')
    end.sort
end

