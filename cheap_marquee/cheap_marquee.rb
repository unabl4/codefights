# https://codefights.com/challenge/3uL94YNXEhHvDFymZ

# lit pixels on the grid (per column, left to right)
# format: 4x5
$pixels = {
    'A' => [4,2,2,4],
    'B' => [5,3,3,2],
    'C' => [3,2,2,2],
    'D' => [5,2,2,3],
    'E' => [5,3,3,2],
    'F' => [5,2,2,1],
    'G' => [3,2,3,3],
    'H' => [5,1,1,5],
    'I' => [2,5,2,2],
    'J' => [2,2,4,1],
    'K' => [5,1,2,2],
    'L' => [5,1,1,1],
    'M' => [5,2,2,5],
    'N' => [5,1,2,5],
    'O' => [3,2,2,3],
    'P' => [5,2,2,1],
    'Q' => [3,2,3,4],
    'R' => [5,3,3,2],
    'S' => [2,3,3,2],
    'T' => [1,5,1,1],
    'U' => [4,1,1,4],
    'V' => [4,1,2,2],
    'W' => [4,2,2,5],
    'X' => [3,2,2,3],
    'Y' => [2,3,1,1],
    'Z' => [3,3,3,2],
    '0' => [3,4,4,3],
    '1' => [2,5,1,1],
    '2' => [2,3,3,2],
    '3' => [3,3,3,2],
    '4' => [2,2,5,1],
    '5' => [4,3,3,2],
    '6' => [3,3,3,2],
    '7' => [2,2,2,2],
    '8' => [2,3,3,2],
    '9' => [2,3,3,3],
    '.' => [1],
    ',' => [2],
    '!' => [4],
    '?' => [1,3,2,1],
    ' ' => [0,0] # 2 spaces (non-lit pixels)
}

# ---

def cheapMarquee(message, width)
    # get pixel grid representation
    grid = message.chars.flat_map do |char|
        pixels = $pixels[char.upcase].dup
        next unless pixels # ignore chars outside the defined range
        pixels << 0 # space pixel
        pixels
    end.reject(&:nil?) # remove nil (ignored) values
    
    i = 1 # current index (increment by one)
    n = grid.size-1 # grid end
    t = s = grid.take(width).reduce(:+) # initial sum
    
    # sliding window
    # 'e' = end
    while (e=i+width-1) <= n
        t = t-grid[i-1]+grid[e]
        s = t if t > s # update max
        i += 1 # next
    end
    
    s # return the max value
end

