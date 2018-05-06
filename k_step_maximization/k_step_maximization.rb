# https://codefights.com/challenge/htWK8EC8ngsRpNiFC

$mirror = {
    '0' => '0',
    '1' => '1',
    '2' => '2',
    '5' => '5',
    '6' => '9',
    '8' => '8',
    '9' => '6'
} # 3,4,7 are incorrect

# rotate by 180 degrees
def rotate(n)
    z = n.to_s # int -> string conversion
    y = z.size
    
    # new number
    (0...y).map do |idx|
        new_idx = y-idx-1 # mirror the direction
        val = z[new_idx]
        new_val = $mirror[val] # mirrored value
        return -1 unless new_val # invalid chars?
        new_val
    end.join.to_i
end

# 0 <= n <= 100
# 1 <= k <= 9
# solve recursively
def kStepMaximization(n, k)
    return n if k <= 0 # base case
    
    # available operations: 1) add '1', 2) multiply by 2, 3) 'rotate'
    [
        kStepMaximization(n+1,k-1),
        kStepMaximization(n*2,k-1),
        kStepMaximization(rotate(n), k-1)
    ].max
end

