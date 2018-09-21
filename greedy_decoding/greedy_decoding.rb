# https://app.codesignal.com/challenge/JhtBKjkeDwaaERovM

def greedyDecoding(message)    
    i = 0
    decoded_msg = ""
    loop do
        break if i >= message.size
        l = message[i..i+1].to_i
        
        if l <= 26
            offset = l
            i+=2
        else
            offset = message[i].to_i
            i+=1
        end
        
        decoded_msg += (offset+64).chr
    end
    
    decoded_msg
end

