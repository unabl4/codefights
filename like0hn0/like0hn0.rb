# https://codefights.com/challenge/kT2y5mZdLZa9Nw8FX

# naive straightforward implementation, 
# no optimizations involved

# get cell visibility
def visibility(grid, row, column)
    n = grid.size # dimensionality
    c = 0 # counter
    
    # tmp values (row/column)
    tr, tc = row, column
    
    # go top
    while (tr-=1) >= 0
        break if grid[tr][column] <= 0
        c += 1
    end
    
    # go right
    while (tc+=1) < n
        break if grid[row][tc] <= 0
        c += 1
    end
    
    # go down
    tr = row # reset
    while (tr+=1) < n
        break if grid[tr][column] <= 0
        c += 1
    end
    
    # go left
    tc = column # reset
    while (tc-=1) >= 0
        break if grid[row][tc] <= 0
        c += 1
    end
    
    c # sum
end

# main func
def like0hn0(grid)
    n = grid.size # grid dimensionality
    (0...n).each do |row|
        (0...n).each do |column|
            cell = grid[row][column] # cell value
            next if cell <= 0 # blocking -> skip, nothing to check
            return false unless visibility(grid,row,column) == cell
        end
    end
    
    true # valid
end

