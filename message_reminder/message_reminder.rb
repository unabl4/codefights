# https://codefights.com/challenge/doWA8nkGsjCqeBfBm

require 'date' # date and datetime

def messageReminder(senders, receivers, dates)
    n = senders.size
    q = [] # queue
    
    # 1st pass
    (0...n).map do |i|
        sender = senders[i]
        receiver = receivers[i]
        date = DateTime.parse(dates[i])
        # history rewind
        q = q.delete_if { |a,b,c| a == receiver && b == sender && date-c <= 2 } # dequeue less than 2 days
        q << [sender, receiver,date] # asana, franko, <whatever>
    end
    
    q.sort_by { |x| x[2] }.map do |a,b,c|
        d = (c+2).strftime("%Y-%m-%d %H:%M:%S")
        "#{d}. #{b} please respond to #{a}"
    end
end

