# https://codefights.com/challenge/hqLbYHvpTMZYYLA6h

def couldBeAnagram(s1,s2)
    return false if s1.size != s2.size
    h = {}
    q = 0 # question mark count
    
    s1.chars.each do |c|
        if c == '?'
            q += 1
        else
            h[c] ||= 0 # init
            h[c] += 1
        end
    end
    
    s2.chars.each do |c|
        if h[c] && h[c] > 0
            h[c] -= 1
        else
            q -= 1 # use question mark placeholders
        end
    end
    
    h.values.all?(&:zero?) && q == 0
end

