# https://codefights.com/challenge/TbAtj9QcCzcJoi2TZ
# brute-force solution

def int237(arr)
    c = 0 # count
    target = 237
    ops = %w(+ - * /) # operations available
    operand_sets = arr.map(&:to_f).permutation # 5 numbers -> 5! = 120
    # 5 operands -> 4 binary operators needed    
    operations = ops.repeated_permutation(4)
    
    operand_sets.each do |ops|
        operations.each do |op|
            exp = ops.zip(op).join
            sum = eval(exp) # math
            c += 1 if (sum-target).abs < 1e-5
        end
    end
    
    c
end

