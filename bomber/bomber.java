// https://app.codesignal.com/challenge/xYpavj2mqzfjDDLGP

// super lame O(n^3) solution
int bomber(char[][] field) {
    int c = 0;  // max
    int h = field.length;
    if(h <= 0) return 0;
    int w = field[0].length;
    
    for(int y=0; y < h; y++) {
        for(int x=0; x < w; x++) {
            if(field[y][x] != '0') continue;
            
            int t = 0;
            
            // right
            for(int z = x; z < w; z++) {
                if(field[y][z] == 'W') break;   // hit a wall
                if(field[y][z] == 'E') t++;
            }
            
            // left
            for(int z = x; z >= 0; z--) {
                if(field[y][z] == 'W') break;   // hit a wall
                if(field[y][z] == 'E') t++;
            }
            
            // up
            for(int z = y; z >= 0; z--) {
                if(field[z][x] == 'W') break;   // hit a wall
                if(field[z][x] == 'E') t++;
            }
            
            // up
            for(int z = y; z < h; z++) {
                if(field[z][x] == 'W') break;   // hit a wall
                if(field[z][x] == 'E') t++;
            }
            
            c = Math.max(c, t);
        }
    }
    
    return c;
}

