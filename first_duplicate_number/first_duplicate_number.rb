# https://codefights.com/challenge/yzcgNgQZHYkQrAfcR

def method_missing _,a
    h = {}
    a.each do |x|
        return x if h[x] # already in the list
        h[x] = 1
    end
    -1
end
