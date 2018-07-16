# https://app.codesignal.com/challenge/LfWCaKHdmeCQk6jZP

def rowsToCols(rows)
    n = rows.size
    rows.map { |x| x.to_s(2).rjust(n,'0').chars }.transpose.map do |x|
        x.join.to_i(2)
    end
end

