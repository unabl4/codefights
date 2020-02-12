// https://app.codesignal.com/challenge/jyhhmX8hQ9jkopLZo

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if(o == null) return true;
        if(o == this) return true;
        if(!(o instanceof Point)) return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public int hashCode() {
        return 37 * x + y;    
    }

    public String toString() {
        return String.format("(x:%d,y:%d)", x,y);
    }
}

String[] wordBoggle(char[][] board, String[] words) {
    String[] w = Stream.of(words)
        .filter(word -> isPresent(board,word))
        .distinct() // unique
        .toArray(String[]::new);

    Arrays.sort(w);    // sort
    return w;
}

// ---

boolean isPresent(char[][] board, String word) {
    for(int j=0; j < board.length; j++) {
        for(int i=0; i < board[j].length; i++) {
            if(word.charAt(0) == board[j][i]) {
                // starting position found
                Point p = new Point(i,j);   // starting point position
                Set<Point> s = new HashSet<>();
                
                if(word.length() <= 1) return true;
                if(F(board,word,s,p,1)) return true;
            }
        }
    }

    return false;   // not found
}

boolean F(char[][] board, String word, Set<Point> v, Point p, int i) {
    v.add(p);   // add the current point as visited

    for(int dy=-1; dy <= 1; dy++) {
        for(int dx=-1; dx <= 1; dx++) {
            if(dy == 0 && dx == 0) continue;  // ignore self
            
            int x = p.x + dx;
            int y = p.y + dy;
            
            Point np = new Point(x,y);  // new point

            if(y < 0 || y >= board.length) continue;
            if(x < 0 || x >= board[y].length) continue;
            if(v.contains(np)) continue;  // already visited

            if(board[y][x] == word.charAt(i)) {
                if(i+1 == word.length()) {
                    // if that was the last letter the find -> the word is found
                    return true;
                } else {
                    Set<Point> vp = new HashSet<>(v);   // copy
                    if(F(board, word, vp, np, i+1)) return true;
                }
            }
        }   // dx
    }   // dy

    return false;   // not found
}
