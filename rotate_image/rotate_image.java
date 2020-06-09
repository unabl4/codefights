// https://app.codesignal.com/challenge/4SH534nNrYxKfZRZp

// O(1) space
int[][] rotateImage(int[][] a) {
    int n = a.length;
    
    for(int j=0; j < n/2; j++) {
        int L = n-2*j;    // width
        
        int S = j;      // start
        int E = j+L-1;  // end
        
        // System.out.print("S: ");
        // System.out.print(S);
        // System.out.print(", E: ");
        // System.out.println(E);
        
        for(int i=S; i < E; i++) {  // abs indexes
            // System.out.print(a[j][i]);
            // System.out.print(", ");
            // System.out.print("J=");
            // System.out.print(j);
            // System.out.print(", I=");
            // System.out.println(i);
            
            int A = a[j][i];    // top edge, top left
            int B = a[i][E];      // right edge    (w->h, h->w)
            int C = a[E][E-(i-S)];    // bottom edge
            int D = a[E-(i-S)][j];    // left edge
            
            // step 1
            
            // System.out.print(A);
            // System.out.print(", ");
            // System.out.print(B);
            // System.out.print(", ");
            // System.out.print(C);
            // System.out.print(", ");
            // System.out.print(D);
            // System.out.print(", ");
            // System.out.println();
            
            // step 2
            a[j][i] = D;
            a[i][E] = A;
            a[E][E-(i-S)] = B;
            a[E-(i-S)][j] = C;
             
            // step 3
            
            // step 4
        }
        
        // System.out.println();
    }
    
    return a;
}

