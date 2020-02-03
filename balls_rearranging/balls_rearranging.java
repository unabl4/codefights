// https://app.codesignal.com/challenge/xs9u2omQGtqgCL65v

int ballsRearranging(int[] b) {
    int n = b.length;
    Arrays.sort(b);    // O(N*log(N))
    // the idea is to to determine the MAX number of balls that can be "fixed",
    // to move the REST of the balls around (either in gaps or sides)
    
    // let L(w) be the length of the sliding window
    // L(w) <= |B|-|w| - the lenght of the sliding window is NO GREATER than the number of the balls remaining 
    
    int f = 1;  // max number of fixed balls; at least one ball can always be fixed
    int t = 0;  // tail; first element
    while(t < n) {    // O(N)
        int h = t+f-1;  // head
        int c = f;  // number of elements taken 
        while(h < n && b[h]-b[t]+1 <= n) {   
            f = Math.max(f,c);
            h++;
            c++;
        }
        
        t++;
    }
    
    return n-f;  // O(N*log(N))
}
