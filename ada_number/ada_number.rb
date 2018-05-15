# https://codefights.com/challenge/Ek56okjWoHkpXwAC5

def adaNumber(line)
    full_basis = %w(0 1 2 3 4 5 6 7 8 9 A B C D E F)
    line.delete!('_') # ignored
    return false if line.empty?
    
	if line.include?("#")
        return false if line.count("#") != 2
        composit = line.split("#")
        return false if composit.size != 2
        base = composit[0].to_i
        return false if base < 2 || base > 16
        basis = full_basis[0...base]
        composit[1].chars.all? { |c| basis.include?(c.upcase) }
    else
        digits = full_basis[0..9]
        line.chars.all? { |c| digits.include?(c) }
    end
end

