// https://app.codesignal.com/challenge/hSzEBWAK4Jhg7YeSP

boolean sudoku2(char[][] grid) {
    for(int i=0; i < 9; i++) {
        if(!isRowValid(grid, i) || !isColumnValid(grid, i) || !isBlockValid(grid, i)) return false;
    }
    
    return true;
}

// ---

boolean isRowValid(char[][] grid, int row) {
    HashMap<Character, Boolean> h = new HashMap<>();
    
    for(int c=0; c < 9; c++) {
        if(grid[row][c] == '.') continue;
        
        if(h.getOrDefault(grid[row][c], false)) return false;
        h.put(grid[row][c], true);
    }
    
    return true;
}

boolean isColumnValid(char[][] grid, int column) {
    HashMap<Character, Boolean> h = new HashMap<>();
    
    for(int r=0; r < 9; r++) {
        if(grid[r][column] == '.') continue;
        
        if(h.getOrDefault(grid[r][column], false)) return false;
        h.put(grid[r][column], true);
    }
    
    return true;
}

boolean isBlockValid(char[][] grid, int blockNumber) {
    int yStart = (blockNumber / 3) * 3; // offset
    int xStart = (blockNumber % 3) * 3;
    
    HashMap<Character, Boolean> h = new HashMap<>();
        
    for(int y=yStart; y < yStart+3; y++) {
        for(int x=xStart; x < xStart+3; x++) {
            if(grid[y][x] == '.') continue;
            
            if(h.getOrDefault(grid[y][x], false)) return false;
            h.put(grid[y][x], true);
        }
    }
    
    return true;
}
