# https://codefights.com/challenge/noThgu6K88YPqceQy

# reverse mapping
$a = {
    'a' => 2,
    'b' => 2,
    'c' => 2,
    
    'd' => 3,
    'e' => 3,
    'f' => 3,
    
    'g' => 4,
    'h' => 4,
    'i' => 4,
    
    'j' => 5,
    'k' => 5,
    'l' => 5,
    
    'm' => 6,
    'n' => 6,
    'o' => 6,
    
    'p' => 7,
    'q' => 7,
    'r' => 7,
    's' => 7,
    
    't' => 8,
    'u' => 8,
    'v' => 8,
    
    'w' => 9,
    'x' => 9,
    'y' => 9,
    'z' => 9
}

# forward mapping
$b = {
    2 => %w(a b c),
    3 => %w(d e f),
    4 => %w(g h i),
    5 => %w(j k l),
    6 => %w(m n o),
    7 => %w(p q r s),
    8 => %w(t u v),
    9 => %w(w x y z)
}


def teeNine(message)
    keys = message.chars.map { |m| $a[m.downcase] || m }
    presses = keys.chunk { |e| e }.map { |(e,ar)| [e, ar.size] } # key presses
    presses.map do |symbol, times|
        if symbol.is_a?(String)
            symbol * times
        else
            z = $b[symbol] # digit -> letter set
            z[(times-1) % z.size] # times -> letter
        end
    end.join
end

