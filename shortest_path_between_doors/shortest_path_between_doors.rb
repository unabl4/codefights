# https://codefights.com/challenge/FRvDNjYNZFDdjkTyb
# optimizations by @miguel_r35

def xy_hash(x,y)
    1000*x+y
end

# find start and exit position coordinates;
# exactly two '2'-s
def find_pos(map)
    pos = []
    h = map.size
    w = map[0].size
    (0...h).each do |y|
        (0...w).each do |x|
            pos << [y,x] if map[y][x] == 2
        end
    end
    
    pos
end

# generate a list of potential moves, avoiding traps
def moves(map, current_pos)
    c = current_pos
    h = (0...map.size)
    w = (0...map[0].size)
    [
        [c[0]-1,c[1]],  # top
        [c[0],c[1]+1],  # right
        [c[0]+1, c[1]], # bottom
        [c[0], c[1]-1]  # left
    ].select { |y,x| h.include?(y) && w.include?(x) && map[y][x] != 1 }
end

def shortestPathBetweenDoors(map)
    start,finish = find_pos(map) # load positions
    
    distances = { xy_hash(start[0],start[1]) => 0 } # ':' declaration cannot be used here
    queue = [start]
    
    until queue.empty?
        current_pos = queue.shift # pop left
        map[current_pos[0]][current_pos[1]] = 1 # visited
        
        # are we there yet?
        return distances[xy_hash(current_pos[0],current_pos[1])] if current_pos == finish
        next_moves = moves(map, current_pos)
        
        # update distances
        distance = (distances[xy_hash(current_pos[0],current_pos[1])] || 0) + 1
        next_moves.each do |next_move|
            queue.push(next_move)
            distances[xy_hash(next_move[0],next_move[1])] = distance
            map[next_move[0]][next_move[1]] = 1 # mark visited early (thanks, miguel_r35)
        end
    end
end
